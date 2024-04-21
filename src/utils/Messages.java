package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Messages {

    protected final String error = "Por favor, digite apenas numeros";
    protected final String ChooseBase  = "Digite o número correspondente a moeda que você deseja converter ";
    protected final String chooseTager = "Digite o número correspondente a moeda que será convertida ";
    protected final String value = "Digite o valor que você deseja que seja convertido, ultize um ponto (.) para as casas decimais.";
    protected final String end = "Programa encerrado com sucesso! ";
    protected final String notOption = "Opção invalida!  ";
    protected final String extendMenu = "Caso não tenha encontrado a moeda de sua procura, digite [1] para estender o menu ou, [2] para continuar.";
    protected final String dotError = "ERRO, talvez você esteja usando virgula(,) ou não digitou um número!";
    protected final String loading = "Carregando, por favor aguarde...";
    protected final String salveFile = "Deseja salvar a sua consulta? [S/N] ";
    protected final String replay = "Deseja fazer uma nova consulta? [S]Sim | [N]Não | [H]Histórico de cunsulta.";
    protected final String salvedSuccessfully = "Salvo com sucesso!";
    protected final String startHistory = "=============== HISTORICO ================";
    protected final String endtHistory = "================= FIM ===================";

    public void menu(){

        System.out.println("""

============================================== CONVERSOR DE MOEDAS =====================================================

O Conversor de Moedas é um programa que converte moedas em tempo real de 155 países. Você pode salvar suas consultas 
em arquivos e também manter um histórico de consultas diretamente do seu terminal.

Aqui estão algumas moedas de alguns países espalhados pelo globo. Para fazer uma conversão, digite o número que 
antecede as moedas de sua escolha, escolhendo primeiramente a moeda base e em seguida a moeda na qual você gostaria de 
converter e, após isso, digite o valor a ser convertido. (Observação: digite ponto [.] para identificar casas decímais.)

Caso a moeda que você procure não esteja no menu abaixo, siga as próximas instruções.

===============================
[1] ARS - Peso argentino
[2] BOB - Boliviano boliviano
[3] BRL - Real brasileiro
[4] CLP - Peso chileno
[5] COP - Peso colombiano
[6] USD - Dólar americano
===============================
""");
        System.out.println(extendMenu);

        Scanner input = new Scanner(System.in);

        while (true) {
            try {

                int number = input.nextInt();
                if (number == 1) {
                    fullMenu();
                    break;

                } else if (number != 2) {

                    System.out.println(notOption);
                    Thread.sleep(1000);
                    menu();
                    break;
                }else{
                    break;
                }
            } catch (InputMismatchException e) {

                System.out.println(error);
                input.nextLine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fullMenu(){

        System.out.println("""
========================================================================================================================
[1] ARS - Peso argentino
[2] BOB - Boliviano boliviano
[3] BRL - Real brasileiro
[4] CLP - Peso chileno
[5] COP - Peso colombiano
[6] USD - Dólar americano
[7] AUD - Australian Dollar - Australia
[8] AWG - Aruban Florin - Aruba
[9] AZN - Azerbaijani Manat - Azerbaijan
[10] BAM - Bosnia and Herzegovina Mark - Bosnia and Herzegovina
[11] BBD - Barbados Dollar - Barbados
[12] BDT - Bangladeshi Taka - Bangladesh
[13] BGN - Bulgarian Lev - Bulgaria
[14] BHD - Bahraini Dinar - Bahrain
[15] BIF - Burundian Franc - Burundi
[16] BMD - Bermudian Dollar - Bermuda
[17] BND - Brunei Dollar - Brunei
[18] BSD - Bahamian Dollar - Bahamas
[19] BTN - Bhutanese Ngultrum - Bhutan
[20] BWP - Botswana Pula - Botswana
[21] BYN - Belarusian Ruble - Belarus
[22] BZD - Belize Dollar - Belize
[23] CAD - Canadian Dollar - Canada
[24] CDF - Congolese Franc - Democratic Republic of the Congo
[25] CHF - Swiss Franc - Switzerland
[26] CNY - Chinese Renminbi - China
[27] CRC - Costa Rican Colon - Costa Rica
[28] CUP - Cuban Peso - Cuba
[29] CVE - Cape Verdean Escudo - Cape Verde
[30] CZK - Czech Koruna - Czech Republic
[31] DJF - Djiboutian Franc - Djibouti
[32] DKK - Danish Krone - Denmark
[33] DOP - Dominican Peso - Dominican Republic
[34] DZD - Algerian Dinar - Algeria
[35] EGP - Egyptian Pound - Egypt
[36] ERN - Eritrean Nakfa - Eritrea
[37] ETB - Ethiopian Birr - Ethiopia
[38] EUR - Euro - European Union
[39] FJD - Fiji Dollar - Fiji
[40] FKP - Falkland Islands Pound - Falkland Islands
[41] FOK - Faroese Króna - Faroe Islands
[42] GEL - Georgian Lari - Georgia
[43] GGP - Guernsey Pound - Guernsey
[44] GHS - Ghanaian Cedi - Ghana
[45] GIP - Gibraltar Pound - Gibraltar
[46] GMD - Gambian Dalasi - The Gambia
[47] GNF - Guinean Franc - Guinea
[48] GTQ - Guatemalan Quetzal - Guatemala
[49] GYD - Guyanese Dollar - Guyana
[50] HKD - Hong Kong Dollar - Hong Kong
[51] HNL - Honduran Lempira - Honduras
[52] HRK - Croatian Kuna - Croatia
[53] HTG - Haitian Gourde - Haiti
[54] HUF - Hungarian Forint - Hungary
[55] IDR - Indonesian Rupiah - Indonesia
[56] ILS - Israeli New Shekel - Israel
[57] IMP - Manx Pound - Isle of Man
[58] INR - Indian Rupee - India
[59] IQD - Iraqi Dinar - Iraq
[60] IRR - Iranian Rial - Iran
[61] ISK - Icelandic Króna - Iceland
[62] JEP - Jersey Pound - Jersey
[63] JMD - Jamaican Dollar - Jamaica
[64] JOD - Jordanian Dinar - Jordan
[65] JPY - Japanese Yen - Japan
[66] KES - Kenyan Shilling - Kenya
[67] KGS - Kyrgyzstani Som - Kyrgyzstan
[68] KHR - Cambodian Riel - Cambodia
[69] KID - Kiribati Dollar - Kiribati
[70] KMF - Comorian Franc - Comoros
[71] KRW - South Korean Won - South Korea
[72] KWD - Kuwaiti Dinar - Kuwait
[73] KYD - Cayman Islands Dollar - Cayman Islands
[74] KZT - Kazakhstani Tenge - Kazakhstan
[75] LAK - Lao Kip - Laos
[76] LBP - Lebanese Pound - Lebanon
[77] LKR - Sri Lanka Rupee - Sri Lanka
[78] LRD - Liberian Dollar - Liberia
[79] LSL - Lesotho Loti - Lesotho
[80] LYD - Libyan Dinar - Libya
[81] MAD - Moroccan Dirham - Morocco
[82] MDL - Moldovan Leu - Moldova
[83] MGA - Malagasy Ariary - Madagascar
[84] MKD - Macedonian Denar - North Macedonia
[85] MMK - Burmese Kyat - Myanmar
[86] MNT - Mongolian Tögrög - Mongolia
[87] MOP - Macanese Pataca - Macau
[88] MRU - Mauritanian Ouguiya - Mauritania
[89] MUR - Mauritian Rupee - Mauritius
[90] MVR - Maldivian Rufiyaa - Maldives
[91] MWK - Malawian Kwacha - Malawi
[92] MXN - Mexican Peso - Mexico
[93] MYR - Malaysian Ringgit - Malaysia
[94] MZN - Mozambican Metical - Mozambique
[95] NAD - Namibian Dollar - Namibia
[96] NGN - Nigerian Naira - Nigeria
[97] NIO - Nicaraguan Córdoba - Nicaragua
[98] NOK - Norwegian Krone - Norway
[99] NPR - Nepalese Rupee - Nepal
[100] NZD - New Zealand Dollar - New Zealand
[101] OMR - Omani Rial - Oman
[102] PAB - Panamanian Balboa - Panama
[103] PEN - Peruvian Sol - Peru
[104] PGK - Papua New Guinean Kina - Papua New Guinea
[105] PHP - Philippine Peso - Philippines
[106] PKR - Pakistani Rupee - Pakistan
[107] PLN - Polish Złoty - Poland
[108] PYG - Paraguayan Guaraní - Paraguay
[109] QAR - Qatari Riyal - Qatar
[110] RON - Romanian Leu - Romania
[111] RSD - Serbian Dinar - Serbia
[112] RUB - Russian Ruble - Russia
[113] RWF - Rwandan Franc - Rwanda
[114] SAR - Saudi Riyal - Saudi Arabia
[115] SBD - Solomon Islands Dollar - Solomon Islands
[116] SCR - Seychellois Rupee - Seychelles
[117] SDG - Sudanese Pound - Sudan
[118] SEK - Swedish Krona - Sweden
[119] SGD - Singapore Dollar - Singapore
[120] SHP - Saint Helena Pound - Saint Helena
[121] SLE - Sierra Leonean Leone - Sierra Leone
[122] SOS - Somali Shilling - Somalia
[123] SRD - Surinamese Dollar - Suriname
[124] SSP - South Sudanese Pound - South Sudan
[125] STN - São Tomé and Príncipe Dobra - São Tomé and Príncipe
[126] SYP - Syrian Pound - Syria
[127] SZL - Eswatini Lilangeni - Eswatini
[128] THB - Thai Baht - Thailand
[129] TJS - Tajikistani Somoni - Tajikistan
[130] TMT - Turkmenistan Manat - Turkmenistan
[131] TND - Tunisian Dinar - Tunisia
[132] TOP - Tongan Paʻanga - Tonga
[133] TRY - Turkish Lira - Turkey
[134] TTD - Trinidad and Tobago Dollar - Trinidad and Tobago
[135] TVD - Tuvaluan Dollar - Tuvalu
[136] TWD - New Taiwan Dollar - Taiwan
[137] TZS - Tanzanian Shilling - Tanzania
[138] UAH - Ukrainian Hryvnia - Ukraine
[139] UGX - Ugandan Shilling - Uganda
[140] USD - United States Dollar - United States
[141] UYU - Uruguayan Peso - Uruguay
[142] UZS - Uzbekistani So'm - Uzbekistan
[143] VES - Venezuelan Bolívar Soberano - Venezuela
[144] VND - Vietnamese Đồng - Vietnam
[145] VUV - Vanuatu Vatu - Vanuatu
[146] WST - Samoan Tālā - Samoa
[147] XAF - Central African CFA Franc - CEMAC
[148] XCD - East Caribbean Dollar - Organisation of Eastern Caribbean States
[149] XDR - Special Drawing Rights - International Monetary Fund
[150] XOF - West African CFA franc - CFA
[151] XPF - CFP Franc - Collectivités d'Outre-Mer
[152] YER - Yemeni Rial - Yemen
[153] ZAR - South African Rand - South Africa
[154] ZMW - Zambian Kwacha - Zambia
[155] ZWL - Zimbabwean Dollar - Zimbabwe
========================================================================================================================
""");
    }
}


