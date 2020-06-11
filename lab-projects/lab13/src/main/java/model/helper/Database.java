package model.helper;

import model.bean.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Database {
    Map<String, User> userMap;
    Map<Integer, Product> productMap;
    String description = "Lorem ipsum dolor sit amet, eam postea virtute invidunt at, error semper quodsi et nam, qui cu tale modus prodesset. Docendi principes eum cu, ex cetero scaevola nec. Viderer mediocrem ea sit. Ne vim ferri graeci, esse explicari est in. Eos eu sale tantas assueverit. Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
            "Sit discere perpetua periculis et. Suavitate principes molestiae sit ad, eu summo perpetua disputando vel. Enim populo te ius, purto timeam expetendis eum ne. Nemore verterem consectetuer te nam, aperiam suavitate at mel. Mei cetero aliquam phaedrum id, qui an quis incorrupte. Cu quo porro integre adipiscing. Nec at ferri placerat. Error luptatum vel ne, ut pri soluta fierent argumentum. Pri brute tritani at.\n" +
            "Accusam praesent explicari no pri. Cibo fugit duo id. Ridens graeco assueverit quo ea. Probo solet prompta vix eu, ut mei tota verterem. Per an mucius dissentias, ne vix docendi maluisset incorrupte, labore definitionem est eu. Ea errem bonorum impedit pro, eum labore mentitum honestatis ut. Qui ea intellegebat signiferumque. Vix docendi recteque expetenda cu. Sit ei regione aliquam, labores scribentur mei ne. Ea vis bonorum ancillae tacimates, at tale ferri vulputate usu.";
    public Database(){
        //user information
        userMap = new HashMap<String,User>();
        for(int i=0;i<1000;i++){
            User u = new User("user"+i,"pass"+i);
            userMap.put(u.getUsername(),u);
        }

        //product information
        productMap = new HashMap<Integer,Product>();
        Random random = new Random();
        int length = 200;
        for(int i=0;i<40;i++){
            int id = i+1;
            int randomNum = random.nextInt(description.length() - length + 1);
            Product p = new Product(id,"Product " + id, description.substring(randomNum, randomNum + length), (float)randomNum/100, 10, "image_"+id+".jpeg");
            productMap.put(id,p);
        }

    }

    public Product findProduct(int productId){
        return productMap.get(productId);
    }

    public void updateStock(int productId, int quantity){
        Product product = findProduct(productId);
        if(product!=null){
            product.setUnitInStock(product.getUnitInStock()-quantity);
        }
    }

    public boolean checkLogin(User u){
        boolean isExisted = false;

        if(u!=null){
            if(userMap.containsKey(u.getUsername())){
                Object objUser = userMap.get(u.getUsername());
                if(objUser != null){
                    User user = (User) objUser;
                    if( user.getPassword().equals(u.getPassword())) {
                        isExisted = true;
                    }
                }
            }
        }

        return  isExisted;
    }

    public List<Product> getProducts(){
        return new ArrayList<Product>(productMap.values());
    }
}