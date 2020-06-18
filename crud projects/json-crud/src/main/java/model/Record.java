package model;

import java.util.*;


public class Record {

    public Record(){
        contactMap = new HashMap<String, Contact>();
        contactMap.put("123",new Contact("123","AHDAHD","87163163213","shdgsh@dsdjfhs.com"));
        contactMap.put("456",new Contact("456","LKSDJF","24243728472","sdssdd@sffsfsf.com"));
        contactMap.put("789",new Contact("789","SSJFSJ","09424242422","rwrewr@hgfhfhf.com"));
    }

    Map<String,Contact> contactMap;

    public Map<String, Contact> getContactList() {
        return contactMap;
    }

    public List<Contact> getContacts(){
        Collection<Contact> contactCollection = contactMap.values();
        List<Contact> contacts = new ArrayList<Contact>();
        for (Contact c:contactCollection) {
            contacts.add(c);
        }
        return contacts;
    }

    public void create(Contact c){
        contactMap.put(c.getId(),c);
    }
    public void update(Contact c){
        if(contactMap.containsKey(c.getId())){
            contactMap.put(c.getId(),c);
        }
    }
    public void delete(Contact c){
        if(contactMap.containsKey(c.getId())){
            contactMap.remove(c.getId());
        }
    }

}
