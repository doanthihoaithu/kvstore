package models;


import java.util.Random;

public class Country {
    
    public static final String[] codes  = { "00","AF",  "AL",  "DZ",  "DS",  "AD",  "AO",  "AI",  "AQ",  "AG",  "AR",  "AM",  "AW",  "AU",  "AT",  "AZ",  "BS",  "BH",
            "BD",  "BB",  "BY",  "BE",  "BZ",  "BJ",  "BM",  "BT",  "BO",  "BA",  "BW",  "BV",  "BR",  "IO",  "BN",  "BG",  "BF",
            "BI",  "KH",  "CM",  "CA",  "CV",  "KY",  "CF",  "TD",  "CL",  "CN",  "CX",  "CC", "CO",  "KM",  "CG",  "CK",  "CR",
            "HR",  "CU",  "CY",  "CZ",  "DK",  "DJ",  "DM",  "DO",  "TP",  "EC",  "EG",  "SV",  "GQ",  "ER",  "EE",  "ET",  "FK",
            "FO",  "FJ",  "FI",  "FR",  "FX",  "GF",  "PF",  "TF",  "GA",  "GM",  "GE",  "DE",  "GH",  "GI",  "GK",  "GR",  "GL",
            "GD",  "GP",  "GU",  "GT",  "GN",  "GW",  "GY",  "HT",  "HM",  "HN",  "HK",  "HU",  "IS",  "IN",  "IM",  "ID",  "IR",
            "IQ",  "IE",  "IL",  "IT",  "CI",  "JE",  "JM",  "JP",  "JO",  "KZ",  "KE",  "KI",  "KP",  "KR",  "XK",  "KW",  "KG",
            "LA",  "LV",  "LB",  "LS",  "LR",  "LY",  "LI",  "LT",  "LU",  "MO",  "MK",  "MG",  "MW",  "MY",  "MV",  "ML",  "MT",
            "MH",  "MQ",  "MR",  "MU",  "TY",  "MX",  "FM",  "MD",  "MC",  "MN",  "ME",  "MS",  "MA",  "MZ",  "MM",  "NA",  "NR",
            "NP",  "NL",  "AN",  "NC",  "NZ",  "NI",  "NE",  "NG",  "NU",  "NF",  "MP",  "NO",  "OM",  "PK",  "PW",  "PS",  "PA",
            "PG",  "PY",  "PE",  "PH",  "PN",  "PL",  "PT",  "PR",  "QA",  "RE",  "RO",  "RU",  "RW",  "KN",  "LC",  "VC",  "WS",
            "SM",  "ST",  "SA",  "SN",  "RS",  "SC",  "SL",  "SG",  "SK",  "SI",  "SB",  "SO",  "ZA",  "GS",  "SS",  "ES",  "LK",
            "SH",  "PM",  "SD",  "SR",  "SJ",  "SZ",  "SE",  "CH",  "SY",  "TW",  "TJ",  "TZ", "TH",  "TG",  "TK",  "TO",  "TT",
            "TN",  "TR",  "TM",  "TC",  "TV",  "UG",  "UA",  "AE",  "GB",  "US",  "UM",  "UY",  "UZ",  "VU",  "VA",  "VE",  "VN",
            "VG", "VI",  "WF",  "EH",  "YE",  "ZR",  "ZM",  "ZW"};
    public static final String [] names={"00", "Afghanistan",
            "Albania",
            "Algeria",
            "American Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antarctica",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bermuda",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Bouvet Island",
            "Brazil",
            "British Indian Ocean Territory",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cape Verde",
            "Cayman Islands",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Christmas Island",
            "Cocos (Keeling) Islands",
            "Colombia",
            "Comoros",
            "Congo",
            "Cook Islands",
            "Costa Rica",
            "Croatia (Hrvatska)",
            "Cuba",
            "Cyprus",
            "Czech Republic",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "East Timor",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Ethiopia",
            "Falkland Islands (Malvinas)",
            "Faroe Islands",
            "Fiji",
            "Finland",
            "France",
            "France, Metropolitan",
            "French Guiana",
            "French Polynesia",
            "French Southern Territories",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Gibraltar",
            "Guernsey",
            "Greece",
            "Greenland",
            "Grenada",
            "Guadeloupe",
            "Guam",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Heard and Mc Donald Islands",
            "Honduras",
            "Hong Kong",
            "Hungary",
            "Iceland",
            "India",
            "Isle of Man",
            "Indonesia",
            "Iran (Islamic Republic of)",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",
            "Ivory Coast",
            "Jersey",
            "Jamaica",
            "Japan",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea, Democratic People Republic of",
            "Korea, Republic of",
            "Kosovo",
            "Kuwait",
            "Kyrgyzstan",
            "Lao People Democratic Republic",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libyan Arab Jamahiriya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macau",
            "Macedonia",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Martinique",
            "Mauritania",
            "Mauritius",
            "Mayotte",
            "Mexico",
            "Micronesia, Federated States of",
            "Moldova, Republic of",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Montserrat",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "Netherlands Antilles",
            "New Caledonia",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Niue",
            "Norfolk Island",
            "Northern Mariana Islands",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Palestine",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Pitcairn",
            "Poland",
            "Portugal",
            "Puerto Rico",
            "Qatar",
            "Reunion",
            "Romania",
            "Russian Federation",
            "Rwanda",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Georgia South Sandwich Islands",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "St. Helena",
            "St. Pierre and Miquelon",
            "Sudan",
            "Suriname",
            "Svalbard and Jan Mayen Islands",
            "Swaziland",
            "Sweden",
            "Switzerland",
            "Syrian Arab Republic",
            "Taiwan",
            "Tajikistan",
            "Tanzania, United Republic of",
            "Thailand",
            "Togo",
            "Tokelau",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Turks and Caicos Islands",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom",
            "United States",
            "United States minor outlying islands",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Vatican City State",
            "Venezuela",
            "Vietnam",
            "Virgin Islands (British)",
            "Virgin Islands (U.S.)",
            "Wallis and Futuna Islands",
            "Western Sahara",
            "Yemen",
            "Zaire",
            "Zambia",
            "Zimbabwe"};
    private int countryId;
    private String countryCode;
    private String countryName;

    public Country(int countryId, String countryCode, String countryName) {
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public void setInformationById(int i) {
        this.countryId = i;
        this.setcountryCode(codes[i]);
        this.setcountryName(names[i]);
    }

    public Country() {
    }

    public int getcountryId() {
        return countryId;
    }

    public void setcountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getcountryCode() {
        return countryCode;
    }

    public void setcountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getcountryName() {
        return countryName;
    }

    public void setcountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setRandom() {
        Random r = new Random();
        int max = codes.length-1;
        int min = 1;
        int i = r.nextInt((max-min)+1) + min;
        this.countryId = i;
        this.countryCode = codes[i];
        this.countryName = names[i];
    }

    public static void main(String[] args) {
        System.out.println(Country.codes.length);
        System.out.println(Country.names.length);

        Country country = new Country();
        country.setRandom();
        System.out.println(country.countryId + " " + country.countryCode + " " + country.countryName);
    }

    public static int getRanDom() {
        Random r = new Random();
        int max = codes.length-1;
        int min = 1;
        int i = r.nextInt((max-min)+1) + min;
        return i;
    }


    
}
