package com.example.facedetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.facedetection.databinding.ActivityMainBinding;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@SuppressWarnings({"deprecation", "ConstantConditions"})
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    InputImage image;
    FaceDetector detector;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String currentPath;
    boolean doubleBackToExitPressedOnce = false;
    Uri deleteImage;
    String tag="faces";
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        setContentView(root);
        binding.takePhoto.setOnClickListener(view -> {
             String fileName="myImage";
            File storageDirectory=getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            try {
                File imageFile=File.createTempFile(fileName,".jpg",storageDirectory);
                currentPath=imageFile.getAbsolutePath();
               Uri imageUri= FileProvider.getUriForFile(MainActivity.this,
                       "com.example.facedetection.fileprovider",imageFile);
               deleteImage =imageUri;
               Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
               if (null != intent.resolveActivity(
                       getPackageManager())) {
                    startActivityForResult(
                            intent, REQUEST_IMAGE_CAPTURE);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            try {
                 bitmap= handleSamplingAndRotationBitmap(this, deleteImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

            binding.testImgView.setImageBitmap(bitmap);

            detectFace(bitmap);
            Log.i(tag,"number of faces detected");
            imageFaceDetection(bitmap);
            Log.i(tag,"identified faces in the image");

            Log.i(tag,"image deleted");
        }
    }
    public static Bitmap handleSamplingAndRotationBitmap(Context context, Uri selectedImage)
            throws IOException {
        int MAX_HEIGHT = 1024;
        int MAX_WIDTH = 1024;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream imageStream = context.getContentResolver().openInputStream(selectedImage);
        BitmapFactory.decodeStream(imageStream, null, options);
        imageStream.close();

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        imageStream = context.getContentResolver().openInputStream(selectedImage);
        Bitmap img = BitmapFactory.decodeStream(imageStream, null, options);

        img = rotateImageIfRequired(context, img, selectedImage);
        return img;
    }
    private static Bitmap rotateImageIfRequired(Context context, Bitmap img, Uri selectedImage) throws IOException {

        InputStream input = context.getContentResolver().openInputStream(selectedImage);
        ExifInterface ei;
        if (Build.VERSION.SDK_INT > 23)
            ei = new ExifInterface(input);
        else
            ei = new ExifInterface(selectedImage.getPath());

        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }
    private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }
    private static int calculateInSampleSize(BitmapFactory.Options options,
                                             int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = Math.min(heightRatio, widthRatio);
            final float totalPixels = width * height;
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }
    public void deleteImage() {

        File fileDelete = new File(currentPath);
        if (fileDelete.exists()) {
            if (fileDelete.delete()) {
                Log.e("-->", "file Deleted :");

            } else {
                Log.e("-->", "file not Deleted :");
            }
        }
    }
    private void imageFaceDetection(Bitmap bitmap) {
        InputImage curImage = InputImage.fromBitmap(bitmap, 0);
        binding.testImgView.setImageBitmap(bitmap);
        try {
            Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(mutableBitmap);

            FaceDetectorOptions highAccuracyOpts =
                    new FaceDetectorOptions.Builder()
                            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                            .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
                            .build();

            FaceDetector detector = FaceDetection.getClient(highAccuracyOpts);

            detector.process(curImage).addOnSuccessListener(faces -> {
                for (Face face : faces) {
                    Rect bounds = face.getBoundingBox();
                    Paint p = new Paint();
                    p.setColor(Color.RED);
                    p.setStyle(Paint.Style.STROKE);
                    p.setStrokeWidth(3);
                    canvas.drawRect(bounds, p);
                    binding.testImgView.setImageBitmap(mutableBitmap);
                }
            }).addOnFailureListener(e -> Log.e("Failure", e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteImage();
    }
    @SuppressLint("DefaultLocale")
    private void detectFace(Bitmap bitmap) {
        FaceDetectorOptions options
                = new FaceDetectorOptions
                .Builder()
                .setPerformanceMode(
                        FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .setLandmarkMode(
                        FaceDetectorOptions
                                .LANDMARK_MODE_ALL)
                .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
                .setClassificationMode(
                        FaceDetectorOptions
                                .CLASSIFICATION_MODE_ALL)
                .enableTracking()
                .build();
        try {
            image = InputImage.fromBitmap(bitmap,  0);
            detector = FaceDetection.getClient(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        detector.process(image)
                .addOnSuccessListener(firebaseVisionFaces -> {
                    String resultText = "";
                    int i = 1;
                    for (Face face :
                            firebaseVisionFaces) {
                        resultText
                                = resultText
                                .concat("\nFACE NUMBER. "
                                        + i + ": ")
                                .concat(
                                        "\nSmile: " +
                                                String.format("%.2f",face.getSmilingProbability() * 100 ) +
                                                "%")
                                .concat(
                                        "\nleft eye open: "
                                                + String.format("%.2f",face.getLeftEyeOpenProbability() * 100 )
                                                + "%")
                                .concat(
                                        "\nright eye open "
                                                + String.format("%.2f",face.getRightEyeOpenProbability() * 100 )
                                                + "%");
                        i++;
                    }

                    if (firebaseVisionFaces.size() == 0) {
                        Toast
                                .makeText(MainActivity.this,
                                        "NO FACE DETECT",
                                        Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString(
                                LCOFaceDetection.RESULT_TEXT,
                                resultText);
                        DialogFragment resultDialog
                                = new ResultDialog();
                        resultDialog.setArguments(bundle);
                        resultDialog.setCancelable(true);
                        resultDialog.show(
                                getSupportFragmentManager(),
                                LCOFaceDetection.RESULT_DIALOG);
                    }
                })
                .addOnFailureListener(e -> Toast
                        .makeText(
                                MainActivity.this,
                                "Something went wrong",
                                Toast.LENGTH_SHORT)
                        .show());
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }
}