package test;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class AlliancesImplTest {

//    @Test
//    public void parseMessagesSentAndStoreShouldParseAndStore() {
//        String[] secretMessages = {"Land,\"Die or play the tame of thrones\""};
//        Alliances alliances = new AlliancesImpl();
//        ArrayList<AlliancesImpl> actualList =  alliances.parseMessagesSentAndStore(secretMessages);
//        AlliancesImpl expectedAlliances = new AlliancesImpl();
//        expectedAlliances.setAllianceName("Land");
//        String expectedMessage = "\"Die or play the tame of thrones\"".toLowerCase();
//        expectedAlliances.setSecretMessage(expectedMessage);
//        ArrayList<AlliancesImpl> expectedAlliancesList = new ArrayList<>();
//        expectedAlliancesList.add(expectedAlliances);
//        Assert.assertEquals(expectedAlliancesList.get(0).getSecretMessage(),actualList.get(0).getSecretMessage());
//    }
//
//    @Test
//    public void processMessageSentByKingdoms() {
//        KingdomImpl kingdom = new KingdomImpl();
//        kingdom.setKingdomName("Air");
//        int[] freq = new int[26];
//        freq['o' - 'a'] = 1;
//        freq['w' - 'a'] = 1;
//        freq['l' - 'a'] = 1;
//        kingdom.setFrequencyEmblem(freq);
//        ArrayList<KingdomImpl> list = new ArrayList<>();
//        list.add(kingdom);
//        AlliancesImpl alliancesImpl = new AlliancesImpl();
//        alliancesImpl.setAllianceName("Air");
//        alliancesImpl.setSecretMessage("\"let’s swing the sword together\"");
//        ArrayList<AlliancesImpl> alliancesArrayList = new ArrayList<>();
//        alliancesArrayList.add(alliancesImpl);
//        Alliances alliances = new AlliancesImpl();
//        String[] actualResultArray = alliances.processMessageSentByKingdoms(list,alliancesArrayList);
//        String[] expectedResultArray = {"Air"};
//        Assert.assertEquals(expectedResultArray,actualResultArray);
//    }
}