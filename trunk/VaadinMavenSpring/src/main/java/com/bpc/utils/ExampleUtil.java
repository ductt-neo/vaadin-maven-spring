package com.bpc.utils;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/15/11
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;

public final class ExampleUtil {

    private static final String[] iso3166 = new String[] { "AFGHANISTAN", "AF",
            "Ã?LAND ISLANDS", "AX", "ALBANIA", "AL", "ALGERIA", "DZ",
            "AMERICAN SAMOA", "AS", "ANDORRA", "AD", "ANGOLA", "AO",
            "ANGUILLA", "AI", "ANTARCTICA", "AQ", "ANTIGUA AND BARBUDA", "AG",
            "ARGENTINA", "AR", "ARMENIA", "AM", "ARUBA", "AW", "AUSTRALIA",
            "AU", "AUSTRIA", "AT", "AZERBAIJAN", "AZ", "BAHAMAS", "BS",
            "BAHRAIN", "BH", "BANGLADESH", "BD", "BARBADOS", "BB", "BELARUS",
            "BY", "BELGIUM", "BE", "BELIZE", "BZ", "BENIN", "BJ", "BERMUDA",
            "BM", "BHUTAN", "BT", "BOLIVIA", "BO", "BOSNIA AND HERZEGOVINA",
            "BA", "BOTSWANA", "BW", "BOUVET ISLAND", "BV", "BRAZIL", "BR",
            "BRITISH INDIAN OCEAN TERRITORY", "IO", "BRUNEI DARUSSALAM", "BN",
            "BULGARIA", "BG", "BURKINA FASO", "BF", "BURUNDI", "BI",
            "CAMBODIA", "KH", "CAMEROON", "CM", "CANADA", "CA", "CAPE VERDE",
            "CV", "CAYMAN ISLANDS", "KY", "CENTRAL AFRICAN REPUBLIC", "CF",
            "CHAD", "TD", "CHILE", "CL", "CHINA", "CN", "CHRISTMAS ISLAND",
            "CX", "COCOS (KEELING) ISLANDS", "CC", "COLOMBIA", "CO", "COMOROS",
            "KM", "CONGO", "CG", "CONGO, THE DEMOCRATIC REPUBLIC OF THE", "CD",
            "COOK ISLANDS", "CK", "COSTA RICA", "CR", "CÃ?TE D'IVOIRE", "CI",
            "CROATIA", "HR", "CUBA", "CU", "CYPRUS", "CY", "CZECH REPUBLIC",
            "CZ", "DENMARK", "DK", "DJIBOUTI", "DJ", "DOMINICA", "DM",
            "DOMINICAN REPUBLIC", "DO", "ECUADOR", "EC", "EGYPT", "EG",
            "EL SALVADOR", "SV", "EQUATORIAL GUINEA", "GQ", "ERITREA", "ER",
            "ESTONIA", "EE", "ETHIOPIA", "ET", "FALKLAND ISLANDS (MALVINAS)",
            "FK", "FAROE ISLANDS", "FO", "FIJI", "FJ", "FINLAND", "FI",
            "FRANCE", "FR", "FRENCH GUIANA", "GF", "FRENCH POLYNESIA", "PF",
            "FRENCH SOUTHERN TERRITORIES", "TF", "GABON", "GA", "GAMBIA", "GM",
            "GEORGIA", "GE", "GERMANY", "DE", "GHANA", "GH", "GIBRALTAR", "GI",
            "GREECE", "GR", "GREENLAND", "GL", "GRENADA", "GD", "GUADELOUPE",
            "GP", "GUAM", "GU", "GUATEMALA", "GT", "GUERNSEY", "GG", "GUINEA",
            "GN", "GUINEA-BISSAU", "GW", "GUYANA", "GY", "HAITI", "HT",
            "HEARD ISLAND AND MCDONALD ISLANDS", "HM",
            "HOLY SEE (VATICAN CITY STATE)", "VA", "HONDURAS", "HN",
            "HONG KONG", "HK", "HUNGARY", "HU", "ICELAND", "IS", "INDIA", "IN",
            "INDONESIA", "ID", "IRAN, ISLAMIC REPUBLIC OF", "IR", "IRAQ", "IQ",
            "IRELAND", "IE", "ISLE OF MAN", "IM", "ISRAEL", "IL", "ITALY",
            "IT", "JAMAICA", "JM", "JAPAN", "JP", "JERSEY", "JE", "JORDAN",
            "JO", "KAZAKHSTAN", "KZ", "KENYA", "KE", "KIRIBATI", "KI",
            "KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF", "KP",
            "KOREA, REPUBLIC OF", "KR", "KUWAIT", "KW", "KYRGYZSTAN", "KG",
            "LAO PEOPLE'S DEMOCRATIC REPUBLIC", "LA", "LATVIA", "LV",
            "LEBANON", "LB", "LESOTHO", "LS", "LIBERIA", "LR",
            "LIBYAN ARAB JAMAHIRIYA", "LY", "LIECHTENSTEIN", "LI", "LITHUANIA",
            "LT", "LUXEMBOURG", "LU", "MACAO", "MO",
            "MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "MK", "MADAGASCAR",
            "MG", "MALAWI", "MW", "MALAYSIA", "MY", "MALDIVES", "MV", "MALI",
            "ML", "MALTA", "MT", "MARSHALL ISLANDS", "MH", "MARTINIQUE", "MQ",
            "MAURITANIA", "MR", "MAURITIUS", "MU", "MAYOTTE", "YT", "MEXICO",
            "MX", "MICRONESIA, FEDERATED STATES OF", "FM",
            "MOLDOVA, REPUBLIC OF", "MD", "MONACO", "MC", "MONGOLIA", "MN",
            "MONTENEGRO", "ME", "MONTSERRAT", "MS", "MOROCCO", "MA",
            "MOZAMBIQUE", "MZ", "MYANMAR", "MM", "NAMIBIA", "NA", "NAURU",
            "NR", "NEPAL", "NP", "NETHERLANDS", "NL", "NETHERLANDS ANTILLES",
            "AN", "NEW CALEDONIA", "NC", "NEW ZEALAND", "NZ", "NICARAGUA",
            "NI", "NIGER", "NE", "NIGERIA", "NG", "NIUE", "NU",
            "NORFOLK ISLAND", "NF", "NORTHERN MARIANA ISLANDS", "MP", "NORWAY",
            "NO", "OMAN", "OM", "PAKISTAN", "PK", "PALAU", "PW",
            "PALESTINIAN TERRITORY, OCCUPIED", "PS", "PANAMA", "PA",
            "PAPUA NEW GUINEA", "PG", "PARAGUAY", "PY", "PERU", "PE",
            "PHILIPPINES", "PH", "PITCAIRN", "PN", "POLAND", "PL", "PORTUGAL",
            "PT", "PUERTO RICO", "PR", "QATAR", "QA", "REUNION", "RE",
            "ROMANIA", "RO", "RUSSIAN FEDERATION", "RU", "RWANDA", "RW",
            "SAINT BARTHÃ?LEMY", "BL", "SAINT HELENA", "SH",
            "SAINT KITTS AND NEVIS", "KN", "SAINT LUCIA", "LC", "SAINT MARTIN",
            "MF", "SAINT PIERRE AND MIQUELON", "PM",
            "SAINT VINCENT AND THE GRENADINES", "VC", "SAMOA", "WS",
            "SAN MARINO", "SM", "SAO TOME AND PRINCIPE", "ST", "SAUDI ARABIA",
            "SA", "SENEGAL", "SN", "SERBIA", "RS", "SEYCHELLES", "SC",
            "SIERRA LEONE", "SL", "SINGAPORE", "SG", "SLOVAKIA", "SK",
            "SLOVENIA", "SI", "SOLOMON ISLANDS", "SB", "SOMALIA", "SO",
            "SOUTH AFRICA", "ZA",
            "SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS", "GS", "SPAIN",
            "ES", "SRI LANKA", "LK", "SUDAN", "SD", "SURINAME", "SR",
            "SVALBARD AND JAN MAYEN", "SJ", "SWAZILAND", "SZ", "SWEDEN", "SE",
            "SWITZERLAND", "CH", "SYRIAN ARAB REPUBLIC", "SY",
            "TAIWAN, PROVINCE OF CHINA", "TW", "TAJIKISTAN", "TJ",
            "TANZANIA, UNITED REPUBLIC OF", "TZ", "THAILAND", "TH",
            "TIMOR-LESTE", "TL", "TOGO", "TG", "TOKELAU", "TK", "TONGA", "TO",
            "TRINIDAD AND TOBAGO", "TT", "TUNISIA", "TN", "TURKEY", "TR",
            "TURKMENISTAN", "TM", "TURKS AND CAICOS ISLANDS", "TC", "TUVALU",
            "TV", "UGANDA", "UG", "UKRAINE", "UA", "UNITED ARAB EMIRATES",
            "AE", "UNITED KINGDOM", "GB", "UNITED STATES", "US",
            "UNITED STATES MINOR OUTLYING ISLANDS", "UM", "URUGUAY", "UY",
            "UZBEKISTAN", "UZ", "VANUATU", "VU", "VENEZUELA", "VE", "VIET NAM",
            "VN", "VIRGIN ISLANDS, BRITISH", "VG", "VIRGIN ISLANDS, U.S.",
            "VI", "WALLIS AND FUTUNA", "WF", "WESTERN SAHARA", "EH", "YEMEN",
            "YE", "ZAMBIA", "ZM", "ZIMBABWE", "ZW" };
    public static final Object iso3166_PROPERTY_NAME = "name";
    public static final Object iso3166_PROPERTY_SHORT = "short";
    public static final Object iso3166_PROPERTY_FLAG = "flag";
    public static final Object hw_PROPERTY_NAME = "name";
    public static final Object hw_PROPERTY_ICON = "icon";

    public static final Object locale_PROPERTY_LOCALE = "locale";
    public static final Object locale_PROPERTY_NAME = "name";
    private static final String[][] locales = { { "fi", "FI", "Finnish" },
            { "de", "DE", "German" }, { "en", "US", "US - English" },
            { "sv", "SE", "Swedish" } };
    private static final String[][] hardware = { //
            { "Desktops", "Dell OptiPlex GX240", "Dell OptiPlex GX260",
                    "Dell OptiPlex GX280" },
            { "Monitors", "Benq T190HD", "Benq T220HD", "Benq T240HD" },
            { "Laptops", "IBM ThinkPad T40", "IBM ThinkPad T43",
                    "IBM ThinkPad T60" } };

    public static final Object PERSON_PROPERTY_FIRSTNAME = "First Name";
    public static final Object PERSON_PROPERTY_LASTNAME = "Last Name";
    private static final String[] firstnames = new String[] { "John", "Mary",
            "Joe", "Sarah", "Jeff", "Jane", "Peter", "Marc", "Robert", "Paula",
            "Lenny", "Kenny", "Nathan", "Nicole", "Laura", "Jos", "Josie",
            "Linus" };
    private static final String[] lastnames = new String[] { "Torvalds",
            "Smith", "Adams", "Black", "Wilson", "Richards", "Thompson",
            "McGoff", "Halas", "Jones", "Beck", "Sheridan", "Picard", "Hill",
            "Fielding", "Einstein" };

    public static final Object ORDER_DESCRIPTION_PROPERTY_ID = "description";
    public static final Object ORDER_QUANTITY_PROPERTY_ID = "quantity";
    public static final Object ORDER_UNITPRICE_PROPERTY_ID = "unitprice";
    public static final Object ORDER_ITEMPRICE_PROPERTY_ID = "itemprice";
    private static final String[] orderDescriptions = new String[] {
            "Email Box", "Domain Name", "Technical Support",
            "E-Commerce Setup", "Web Hosting", "SSL Certificate" };

    public static IndexedContainer getPersonContainer() {
        IndexedContainer contactContainer = new IndexedContainer();
        contactContainer.addContainerProperty(PERSON_PROPERTY_FIRSTNAME,
                String.class, "");
        contactContainer.addContainerProperty(PERSON_PROPERTY_LASTNAME,
                String.class, "");

        Random r = new Random(5);
        for (int i = 0; i < 50;) {
            String fn = firstnames[(int) (r.nextDouble() * firstnames.length)];
            String ln = lastnames[(int) (r.nextDouble() * lastnames.length)];
            String id = fn + ln;
            Item item = contactContainer.addItem(id);
            if (item != null) {
                i++;
                item.getItemProperty(PERSON_PROPERTY_FIRSTNAME).setValue(fn);
                item.getItemProperty(PERSON_PROPERTY_LASTNAME).setValue(ln);
            }
        }
        return contactContainer;
    }

    public static IndexedContainer getLocaleContainer() {
        IndexedContainer localeContainer = new IndexedContainer();
        localeContainer.addContainerProperty(locale_PROPERTY_LOCALE,
                Locale.class, null);
        localeContainer.addContainerProperty(locale_PROPERTY_NAME,
                String.class, null);
        for (int i = 0; i < locales.length; i++) {
            String id = locales[i][2];
            Item item = localeContainer.addItem(id);
            item.getItemProperty(locale_PROPERTY_LOCALE).setValue(
                    new Locale(locales[i][0], locales[i][1]));
            item.getItemProperty(locale_PROPERTY_NAME).setValue(locales[i][2]);
        }

        return localeContainer;
    }

    @Deprecated
    public static IndexedContainer getStaticISO3166Container() {
        return getISO3166Container();
    }

    public static IndexedContainer getISO3166Container() {
        IndexedContainer c = new IndexedContainer();
        fillIso3166Container(c);
        return c;
    }

    private static void fillIso3166Container(IndexedContainer container) {
        container.addContainerProperty(iso3166_PROPERTY_NAME, String.class,
                null);
        container.addContainerProperty(iso3166_PROPERTY_SHORT, String.class,
                null);
        container.addContainerProperty(iso3166_PROPERTY_FLAG, Resource.class,
                null);
        for (int i = 0; i < iso3166.length; i++) {
            String name = iso3166[i++];
            String id = iso3166[i];
            Item item = container.addItem(id);
            item.getItemProperty(iso3166_PROPERTY_NAME).setValue(name);
            item.getItemProperty(iso3166_PROPERTY_SHORT).setValue(id);
            item.getItemProperty(iso3166_PROPERTY_FLAG).setValue(
                    new ThemeResource("../sampler/flags/" + id.toLowerCase()
                            + ".gif"));
        }
        container.sort(new Object[] { iso3166_PROPERTY_NAME },
                new boolean[] { true });
    }

    public static HierarchicalContainer getHardwareContainer() {
        Item item = null;
        int itemId = 0; // Increasing numbering for itemId:s

        // Create new container
        HierarchicalContainer hwContainer = new HierarchicalContainer();
        // Create containerproperty for name
        hwContainer.addContainerProperty(hw_PROPERTY_NAME, String.class, null);
        // Create containerproperty for icon
        hwContainer.addContainerProperty(hw_PROPERTY_ICON, ThemeResource.class,
                new ThemeResource("../runo/icons/16/document.png"));
        for (int i = 0; i < hardware.length; i++) {
            // Add new item
            item = hwContainer.addItem(itemId);
            // Add name property for item
            item.getItemProperty(hw_PROPERTY_NAME).setValue(hardware[i][0]);
            // Allow children
            hwContainer.setChildrenAllowed(itemId, true);
            itemId++;
            for (int j = 1; j < hardware[i].length; j++) {
                if(j==1) {
                    item.getItemProperty(hw_PROPERTY_ICON).setValue(new ThemeResource("../runo/icons/16/folder.png"));
                }
                // Add child items
                item = hwContainer.addItem(itemId);
                item.getItemProperty(hw_PROPERTY_NAME).setValue(hardware[i][j]);
                hwContainer.setParent(itemId, itemId - j);
                hwContainer.setChildrenAllowed(itemId, false);

                itemId++;
            }
        }
        return hwContainer;
    }

    public static void fillContainerWithEmailAddresses(Container c, int amount) {
        for (int i = 0; i < amount; i++) {
            // TODO
        }
    }

    public static IndexedContainer getOrderContainer() {
        IndexedContainer container = new IndexedContainer();

        // Create the container properties
        container.addContainerProperty(ORDER_DESCRIPTION_PROPERTY_ID,
                String.class, "");
        container.addContainerProperty(ORDER_QUANTITY_PROPERTY_ID,
                Integer.class, 0);
        container.addContainerProperty(ORDER_UNITPRICE_PROPERTY_ID,
                String.class, "$0");
        container.addContainerProperty(ORDER_ITEMPRICE_PROPERTY_ID,
                String.class, "$0");

        // Create some orders
        addOrderToContainer(container, "Domain Name", 3, 7.99);
        addOrderToContainer(container, "SSL Certificate", 1, 119.00);
        addOrderToContainer(container, "Web Hosting", 1, 19.95);
        addOrderToContainer(container, "Email Box", 20, 0.15);
        addOrderToContainer(container, "E-Commerce Setup", 1, 25.00);
        addOrderToContainer(container, "Technical Support", 1, 50.00);

        return container;
    }

    private static void addOrderToContainer(Container container,
            String description, int quantity, double price) {
        Object itemId = container.addItem();
        Item item = container.getItem(itemId);
        item.getItemProperty(ORDER_DESCRIPTION_PROPERTY_ID).setValue(
                description);
        item.getItemProperty(ORDER_QUANTITY_PROPERTY_ID).setValue(quantity);
        item.getItemProperty(ORDER_UNITPRICE_PROPERTY_ID).setValue(
                NumberFormat.getCurrencyInstance().format(price));
        item.getItemProperty(ORDER_ITEMPRICE_PROPERTY_ID).setValue(
                NumberFormat.getCurrencyInstance().format(price * quantity));
    }

}