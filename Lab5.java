/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softcons.citysearch.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import softcons.citysearch.model.City;
import softcons.citysearch.model.Employee;

/**
 *
 * @author ibrah   
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String csv = "GeoLiteCity-Location.csv";
        String line;
        int x=0;
        List<String> list = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            
            while((line = br.readLine()) != null)
            {
                list.add(line);
            }

//            String[] stringArr = list.toArray(new String[0]);
            System.out.println(list.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
                SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//creating session object  
		Session session=factory.openSession();  
			//creating transaction object  
			Transaction t=session.beginTransaction();  
//			Employee e1=new Employee();  
//			e1.setId(116);  
//			e1.setFirst_name("Fahad");  
//			e1.setLast_name("Satti");  
//			session.persist(e1);//persisting the object  

                        City city = new City();
                        String[] data;
                        while(!list.isEmpty()){
                            data = list.get(0).split(",");
                            System.out.println(data);
                            city.setLocId(Integer.parseInt(data[0]));
                            city.setCountry(data[1]);
                            city.setRegion(data[2]);
                            city.setCity(data[3]);
                            city.setPostalCode(Integer.parseInt(data[4]));
                            city.setLatitude(Float.valueOf(data[5]));
                            city.setLongitude(Float.valueOf(data[6]));
                            city.setMetroCode(Integer.parseInt(data[7]));
                            city.setAreaCode(Integer.parseInt(data[8]));
                            session.persist(city);
                        }
			t.commit();//transaction is commited  
		session.close(); 
        
        
        
    }
    
}
