package com.example.covid_19tracker.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DistrictsData {
    public static ArrayList<String> getStates(String state) {
        switch (state) {
            case "Andaman and Nicobar Islands":
                return new ArrayList<>(
                        Arrays.asList(
                                "Nicobars",
                                "North and Middle Andaman",
                                "South Andaman",
                                "Unknown"
                        )
                );

            case "Andhra Pradesh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Anantapur",
                                "Chittoor",
                                "East Godavari",
                                "Guntur",
                                "Krishna",
                                "Kurnool",
                                "Prakasam",
                                "S.P.S. Nellore",
                                "Srikakulam",
                                "Visakhapatnam",
                                "Vizianagaram",
                                "West Godavari",
                                "Y.S.R. Kadapa"


                        )
                );
            case "Arunachal Pradesh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Anjaw",
                                "Changlang",
                                "East Kameng",
                                "East Siang",
                                "Kamle",
                                "Kra Daadi",
                                "Kurung Kumey",
                                "Lepa Rada",
                                "Lohit",
                                "Longding",
                                "Lower Dibang Valley",
                                "Lower Siang",
                                "Lower Subansiri",
                                "Namsai",
                                "Pakke Kessang",
                                "Papum Pare",
                                "Shi Yomi",
                                "Siang",
                                "Tawang",
                                "Tirap",
                                "Upper Dibang Valley",
                                "Upper Siang",
                                "Upper Siang",
                                "Upper Subansiri",
                                "West Kameng",
                                "West Siang"


                        )
                );
            case "Assam":
                return new ArrayList<>(
                        Arrays.asList(
                                "Airport Quarantine",
                                "Baksa",
                                "Barpeta",
                                "Biswanath",
                                "Bongaigaon",
                                "Cachar",
                                "Charaideo",
                                "Chirang",
                                "Darrang",
                                "Dhemaji",
                                "Dhubri",
                                "Dibrugarh",
                                "Dima Hasao",
                                "Goalpara",
                                "Golaghat",
                                "Hailakandi",
                                "Hojai",
                                "Jorhat",
                                "Kamrup",
                                "Kamrup Metropolitan",
                                "Karbi Anglong",
                                "Karimganj",
                                "Kokrajhar",
                                "Lakhimpur",
                                "Majuli",
                                "Morigaon",
                                "Nagaon",
                                "Nalbari",
                                "Other State",
                                "Sivasagar",
                                "Sonitpur",
                                "South Salmara Mankachar",
                                "Tinsukia",
                                "Udalguri",
                                "West Karbi Anglong"


                        )
                );
            case "Bihar":
                return new ArrayList<>(
                        Arrays.asList(
                                "Araria",
                                "Arwal",
                                "Aurangabad",
                                "Banka",
                                "Begusarai",
                                "Bhagalpur",
                                "Bhojpur",
                                "Buxar",
                                "Darbhanga",
                                "East Champaran",
                                "Gaya",
                                "Gopalganj",
                                "Jamui",
                                "Jehanabad",
                                "Kaimur",
                                "Katihar",
                                "Khagaria",
                                "Kishanganj",
                                "Lakhisarai",
                                "Madhepura",
                                "Madhubani",
                                "Munger",
                                "Muzaffarpur",
                                "Nalanda",
                                "Nawada",
                                "Patna",
                                "Purnia",
                                "Rohtas",
                                "Saharsa",
                                "Samastipur",
                                "Saran",
                                "Sheikhpura",
                                "Sheohar",
                                "Sitamarhi",
                                "Siwan",
                                "Supaul",
                                "Vaishali",
                                "West Champaran"
                        )
                );

            case "Chandigarh":
                return new ArrayList<>(
                        Collections.singletonList(
                                "Chandigarh"
                        )
                );

            case "Chhattisgarh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Balod",
                                "Baloda Bazar",
                                "Balrampur",
                                "Bametara",
                                "Bastar",
                                "Bijapur",
                                "Bilaspur",
                                "Dakshin Bastar Dantewada",
                                "Dhamtari",
                                "Durg",
                                "Gariaband",
                                "Janjgir Champa",
                                "Jashpur",
                                "Kabeerdham",
                                "Kondagaon",
                                "Korba",
                                "Koriya",
                                "Mahasamund",
                                "Mungeli",
                                "Narayanpur",
                                "Raigarh",
                                "Raipur",
                                "Rajnandgaon",
                                "Sukma",
                                "Surajpur",
                                "Surguja",
                                "Uttar Bastar Kanker",
                                "Gaurela Pendra Marwahi"


                        )
                );
            case "Dadra and Nagar Haveli and Daman and Diu":
                return new ArrayList<>(
                        Arrays.asList(
                                "Dadra and Nagar Haveli",
                                "Daman",
                                "Diu"
                        )
                );
            case "Delhi":
                return new ArrayList<>(
                        Arrays.asList(
                                "Central Delhi",
                                "East Delhi",
                                "New Delhi",
                                "North Delhi",
                                "North East Delhi",
                                "North West Delhi",
                                "Shahdara",
                                "South Delhi",
                                "South East Delhi",
                                "South West Delhi",
                                "West Delhi"

                        )
                );
            case "Goa":
                return new ArrayList<>(
                        Arrays.asList(

                                "North Goa",
                                "South Goa"

                        )
                );
            case "Gujarat":
                return new ArrayList<>(
                        Arrays.asList(
                                "Ahmedabad",
                                "Amreli",
                                "Anand",
                                "Aravalli",
                                "Banaskantha",
                                "Bharuch",
                                "Bhavnagar",
                                "Botad",
                                "Chhota Udaipur",
                                "Dahod",
                                "Dang",
                                "Devbhumi Dwarka",
                                "Gandhinagar",
                                "Gir Somnath",
                                "Jamnagar",
                                "Junagadh",
                                "Kheda",
                                "Kutch",
                                "Mahisagar",
                                "Mehsana",
                                "Morbi",
                                "Narmada",
                                "Navsari",
                                "Panchmahal",
                                "Patan",
                                "Porbandar",
                                "Rajkot",
                                "Sabarkantha",
                                "Surat",
                                "Surendranagar",
                                "Tapi",
                                "Vadodara",
                                "Valsad"


                        )
                );
            case "Haryana":
                return new ArrayList<>(
                        Arrays.asList(
                                "Ambala",
            "Bhiwani",
            "Charkhi Dadri",
            "Faridabad",
            "Fatehabad",
            "Gurugram",
            "Hisar",
            "Italians",
            "Jhajjar",
            "Jind",
            "Kaithal",
            "Karnal",
            "Kurukshetra",
            "Mahendragarh",
            "Nuh",
            "Palwal",
            "Panchkula",
            "Panipat",
            "Rewari",
            "Rohtak",
            "Sirsa",
            "Sonipat",
            "Yamunanagar"


                        )
                );
            case "Himachal Pradesh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Bilaspur",
            "Chamba",
            "Hamirpur",
            "Kangra",
            "Kinnaur",
            "Kullu",
            "Lahaul and Spiti",
            "Mandi",
            "Shimla",
            "Sirmaur",
            "Solan",
            "Una"


                        )
                );
            case "Jammu and Kashmir":
                return new ArrayList<>(
                        Arrays.asList(
                                "Anantnag",
            "Bandipora",
            "Baramulla",
            "Budgam",
            "Doda",
            "Ganderbal",
            "Jammu",
            "Kathua",
            "Kishtwar",
            "Kulgam",
            "Kupwara",
            "Mirpur",
            "Muzaffarabad",
            "Pulwama",
            "Punch",
            "Rajouri",
            "Ramban",
            "Reasi",
            "Samba",
            "Shopiyan",
            "Srinagar",
            "Udhampur"


                        )
                );
            case "Jharkhand":
                return new ArrayList<>(
                        Arrays.asList(
                                "Bokaro",
            "Chatra",
            "Deoghar",
            "Dhanbad",
            "Dumka",
            "East Singhbhum",
            "Garhwa",
            "Giridih",
            "Godda",
            "Gumla",
            "Hazaribagh",
            "Jamtara",
            "Khunti",
            "Koderma",
            "Latehar",
            "Lohardaga",
            "Pakur",
            "Palamu",
            "Ramgarh",
            "Ranchi",
            "Sahibganj",
            "Saraikela-Kharsawan",
            "Simdega",
            "West Singhbhum"


                        )
                );
            case "Karnataka":
                return new ArrayList<>(
                        Arrays.asList(
                                "Bagalkote",
            "Ballari",
            "Belagavi",
            "Bengaluru Rural",
            "Bengaluru Urban",
            "Bidar",
            "Chamarajanagara",
            "Chikkaballapura",
            "Chikkamagaluru",
            "Chitradurga",
            "Dakshina Kannada",
            "Davanagere",
            "Dharwad",
            "Gadag",
            "Hassan",
            "Haveri",
            "Kalaburagi",
            "Kodagu",
            "Kolar",
            "Koppal",
            "Mandya",
            "Mysuru",
            "Other State",
            "Raichur",
            "Ramanagara",
            "Shivamogga",
            "Tumakuru",
            "Udupi",
            "Uttara Kannada",
            "Vijayapura",
            "Yadgir"
                        )
                );
            case "Kerala":
                return new ArrayList<>(
                        Arrays.asList(
                                "Alappuzha",
            "Ernakulam",
            "Idukki",
            "Kannur",
            "Kasaragod",
            "Kollam",
            "Kottayam",
            "Kozhikode",
            "Malappuram",
            "Palakkad",
            "Pathanamthitta",
            "Thiruvananthapuram",
            "Thrissur",
            "Wayanad"
                        )
                );
            case "Ladakh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Kargil",
            "Leh"
                        )
                );
            case "Lakshadweep":
                return new ArrayList<>(
                        Collections.singletonList(

                                "Lakshadweep"
                        )
                );
            case "Madhya Pradesh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Agar Malwa",
            "Alirajpur",
            "Anuppur",
            "Ashoknagar",
            "Balaghat",
            "Barwani",
            "Betul",
            "Bhind",
            "Bhopal",
            "Burhanpur",
            "Chhatarpur",
            "Chhindwara",
            "Damoh",
            "Datia",
            "Dewas",
            "Dhar",
            "Dindori",
            "Guna",
            "Gwalior",
            "Harda",
            "Hoshangabad",
            "Indore",
            "Jabalpur",
            "Jhabua",
            "Katni",
            "Khandwa",
            "Khargone",
            "Mandla",
            "Mandsaur",
            "Morena",
            "Narsinghpur",
            "Neemuch",
            "Niwari",
            "Other Region",
            "Panna",
            "Raisen",
            "Rajgarh",
            "Ratlam",
            "Rewa",
            "Sagar",
            "Satna",
            "Sehore",
            "Seoni",
            "Shahdol",
            "Shajapur",
            "Sheopur",
            "Shivpuri",
            "Sidhi",
            "Singrauli",
            "Tikamgarh",
            "Ujjain",
            "Umaria",
            "Vidisha"
                        )
                );
            case "Maharashtra":
                return new ArrayList<>(
                        Arrays.asList(
                                "Ahmednagar",
            "Akola",
            "Amravati",
            "Aurangabad",
            "Beed",
            "Bhandara",
            "Buldhana",
            "Chandrapur",
            "Dhule",
            "Gadchiroli",
            "Gondia",
            "Hingoli",
            "Jalgaon",
            "Jalna",
            "Kolhapur",
            "Latur",
            "Mumbai",
            "Mumbai Suburban",
            "Nagpur",
            "Nanded",
            "Nandurbar",
            "Nashik",
            "Osmanabad",
            "Palghar",
            "Parbhani",
            "Pune",
            "Raigad",
            "Ratnagiri",
            "Sangli",
            "Satara",
            "Sindhudurg",
            "Solapur",
            "Thane",
            "Wardha",
            "Washim",
            "Yavatmal"
                        )
                );
            case "Manipur":
                return new ArrayList<>(
                        Arrays.asList(
                                "Bishnupur",
            "Chandel",
            "Churachandpur",
            "Imphal East",
            "Imphal West",
            "Jiribam",
            "Kakching",
            "Kamjong",
            "Kangpokpi",
            "Noney",
            "Pherzawl",
            "Senapati",
            "Tamenglong",
            "Tengnoupal",
            "Thoubal",
            "Ukhrul"
                        )
                );
            case "Meghalaya":
                return new ArrayList<>(
                        Arrays.asList(
                                "East Garo Hills",
            "East Jaintia Hills",
            "East Khasi Hills",
            "North Garo Hills",
            "Ribhoi",
            "South Garo Hills",
            "South West Garo Hills",
            "South West Khasi Hills",
            "West Garo Hills",
            "West Jaintia Hills",
            "West Khasi Hills"
                        )
                );
            case "Mizoram":
                return new ArrayList<>(
                        Arrays.asList(
                                "Aizawl",
            "Champhai",
            "Hnahthial",
            "Khawzawl",
            "Kolasib",
            "Lawngtlai",
            "Lunglei",
            "Mamit",
            "Saiha",
            "Saitual",
            "Serchhip"
                        )
                );
            case "Nagaland":
                return new ArrayList<>(
                        Arrays.asList(
                                "Dimapur",
            "Kiphire",
            "Kohima",
            "Longleng",
            "Mokokchung",
            "Mon",
            "Peren",
            "Phek",
            "Tuensang",
            "Wokha",
            "Zunheboto"
                        )
                );
            case "Odisha":
                return new ArrayList<>(
                        Arrays.asList(
                                "Angul",
            "Balangir",
            "Balasore",
            "Bargarh",
            "Bhadrak",
            "Boudh",
            "Cuttack",
            "Deogarh",
            "Dhenkanal",
            "Gajapati",
            "Ganjam",
            "Jagatsinghpur",
            "Jajpur",
            "Jharsuguda",
            "Kalahandi",
            "Kandhamal",
            "Kendrapara",
            "Kendujhar",
            "Khordha",
            "Koraput",
            "Malkangiri",
            "Mayurbhanj",
            "Nabarangapur",
            "Nayagarh",
            "Nuapada",
            "Puri",
            "Rayagada",
            "Sambalpur",
            "Subarnapur",
            "Sundargarh"
                        )
                );
            case "Puducherry":
                return new ArrayList<>(
                        Arrays.asList(
                                "Karaikal",
            "Mahe",
            "Puducherry",
            "Yanam"
                        )
                );

            case "Punjab":
                return new ArrayList<>(
                        Arrays.asList(
                                "Amritsar",
            "Barnala",
            "Bathinda",
            "Faridkot",
            "Fatehgarh Sahib",
            "Fazilka",
            "Ferozepur",
            "Gurdaspur",
            "Hoshiarpur",
            "Jalandhar",
            "Kapurthala",
            "Ludhiana",
            "Mansa",
            "Moga",
            "Pathankot",
            "Patiala",
            "Rupnagar",
            "S.A.S. Nagar",
            "Sangrur",
            "Shahid Bhagat Singh Nagar",
            "Sri Muktsar Sahib",
            "Tarn Taran"
                        )
                );

            case "Rajasthan":
                return new ArrayList<>(
                        Arrays.asList(
                                "Ajmer",
            "Alwar",
            "Banswara",
            "Baran",
            "Barmer",
            "Bharatpur",
            "Bhilwara",
            "Bikaner",
            "BSF Camp",
            "Bundi",
            "Chittorgarh",
            "Churu",
            "Dausa",
            "Dholpur",
            "Dungarpur",
            "Evacuees",
            "Ganganagar",
            "Hanumangarh",
            "Italians",
            "Jaipur",
            "Jaisalmer",
            "Jalore",
            "Jhalawar",
            "Jhunjhunu",
            "Jodhpur",
            "Karauli",
            "Kota",
            "Nagaur",
            "Pali",
            "Pratapgarh",
            "Rajsamand",
            "Sawai Madhopur",
            "Sikar",
            "Sirohi",
            "Tonk",
            "Udaipur"
                        )
                );

            case "Sikkim":
                return new ArrayList<>(
                        Arrays.asList(
                                "East Sikkim",
            "North Sikkim",
            "South Sikkim",
            "West Sikkim"
                        )
                );

            case "Tamil Nadu":
                return new ArrayList<>(
                        Arrays.asList(
                                "Ariyalur",
            "Chengalpattu",
            "Chennai",
            "Coimbatore",
            "Cuddalore",
            "Dharmapuri",
            "Dindigul",
            "Erode",
            "Kallakurichi",
            "Kancheepuram",
            "Kanyakumari",
            "Karur",
            "Krishnagiri",
            "Madurai",
            "Nagapattinam",
            "Namakkal",
            "Nilgiris",
            "Perambalur",
            "Pudukkottai",
            "Ramanathapuram",
            "Ranipet",
            "Salem",
            "Sivaganga",
            "Tenkasi",
            "Thanjavur",
            "Theni",
            "Thiruvallur",
            "Thiruvarur",
            "Thoothukkudi",
            "Tiruchirappalli",
            "Tirunelveli",
            "Tirupathur",
            "Tiruppur",
            "Tiruvannamalai",
            "Vellore",
            "Viluppuram",
            "Virudhunagar",
            "Mayiladuthurai"
                        )
                );

            case "Telangana":
                return new ArrayList<>(
                        Arrays.asList(
                                "Adilabad",
            "Bhadradri Kothagudem",
            "Hyderabad",
            "Jagtial",
            "Jangaon",
            "Jayashankar Bhupalapally",
            "Jogulamba Gadwal",
            "Kamareddy",
            "Karimnagar",
            "Khammam",
            "Komaram Bheem",
            "Mahabubabad",
            "Mahabubnagar",
            "Mancherial",
            "Medak",
            "Medchal Malkajgiri",
            "Mulugu",
            "Nagarkurnool",
            "Nalgonda",
            "Narayanpet",
            "Nirmal",
            "Nizamabad",
            "Peddapalli",
            "Rajanna Sircilla",
            "Ranga Reddy",
            "Sangareddy",
            "Siddipet",
            "Suryapet",
            "Vikarabad",
            "Wanaparthy",
            "Warangal Rural",
            "Warangal Urban",
            "Yadadri Bhuvanagiri"
                        )
                );
            case "Tripura":
                return new ArrayList<>(
                        Arrays.asList(
                                "Dhalai",
            "Gomati",
            "Khowai",
            "North Tripura",
            "Sipahijala",
            "South Tripura",
            "Unokoti",
            "West Tripura"
                        )
                );

            case "Uttar Pradesh":
                return new ArrayList<>(
                        Arrays.asList(
                                "Agra",
            "Aligarh",
            "Ambedkar Nagar",
            "Amethi",
            "Amroha",
            "Auraiya",
            "Ayodhya",
            "Azamgarh",
            "Baghpat",
            "Bahraich",
            "Ballia",
            "Balrampur",
            "Banda",
            "Barabanki",
            "Bareilly",
            "Basti",
            "Bhadohi",
            "Bijnor",
            "Budaun",
            "Bulandshahr",
            "Chandauli",
            "Chitrakoot",
            "Deoria",
            "Etah",
            "Etawah",
            "Farrukhabad",
            "Fatehpur",
            "Firozabad",
            "Gautam Buddha Nagar",
            "Ghaziabad",
            "Ghazipur",
            "Gonda",
            "Gorakhpur",
            "Hamirpur",
            "Hapur",
            "Hardoi",
            "Hathras",
            "Jalaun",
            "Jaunpur",
            "Jhansi",
            "Kannauj",
            "Kanpur Dehat",
            "Kanpur Nagar",
            "Kasganj",
            "Kaushambi",
            "Kushinagar",
            "Lakhimpur Kheri",
            "Lalitpur",
            "Lucknow",
            "Maharajganj",
            "Mahoba",
            "Mainpuri",
            "Mathura",
            "Mau",
            "Meerut",
            "Mirzapur",
            "Moradabad",
            "Muzaffarnagar",
            "Pilibhit",
            "Pratapgarh",
            "Prayagraj",
            "Rae Bareli",
            "Rampur",
            "Saharanpur",
            "Sambhal",
            "Sant Kabir Nagar",
            "Shahjahanpur",
            "Shamli",
            "Shrawasti",
            "Siddharthnagar",
            "Sitapur",
            "Sonbhadra",
            "Sultanpur",
            "Unnao",
            "Varanasi"
                        )
                );

            case "Uttarakhand":
                return new ArrayList<>(
                        Arrays.asList(
                                "Almora",
            "Bageshwar",
            "Chamoli",
            "Champawat",
            "Dehradun",
            "Haridwar",
            "Nainital",
            "Pauri Garhwal",
            "Pithoragarh",
            "Rudraprayag",
            "Tehri Garhwal",
            "Udham Singh Nagar",
            "Uttarkashi"
                        )
                );
            case "West Bengal":
                return new ArrayList<>(
                        Arrays.asList(
                                "Alipurduar",
            "Bankura",
            "Birbhum",
            "Cooch Behar",
            "Dakshin Dinajpur",
            "Darjeeling",
            "Hooghly",
            "Howrah",
            "Jalpaiguri",
            "Jhargram",
            "Kalimpong",
            "Kolkata",
            "Malda",
            "Murshidabad",
            "Nadia",
            "North 24 Parganas",
            "Paschim Bardhaman",
            "Paschim Medinipur",
            "Purba Bardhaman",
            "Purba Medinipur",
            "Purulia",
            "South 24 Parganas",
            "Uttar Dinajpur"
                        )
                );
        }
        return new ArrayList<>();
    }
}

