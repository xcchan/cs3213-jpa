/**
 * Name   1 :   Edward Chan
 * Matric 1 :   A0097   H
 *
 * Name   2 :   Koh Zheng Kang
 * Matric 2 :   A0097973H
 */
 
package coolshot;

import javax.persistence.*;
import java.util.List;
import java.util.Iterator;

public class QueryTest {    
    
	public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CoolShotPU");		
		EntityManager em = emf.createEntityManager();
        
        // count all reviews for each movie
        System.out.println("Review count: ");
        //
        // Task 3: your code here
        //
        // 1. Create a query
        // 2. Get result list
        // 3. Iterate through the result list and print out
        //

        Query query = em.createQuery("SELECT m.title, COUNT(r.id) AS 'NumOfReviews' FROM Review r INNER JOIN Movie m ON r.movie_id = m.id GROUP BY m.title");
        List results = query.getResultList();
        for(Object obj : results) {
                System.out.println(obj.toString());
        }
        System.out.println();
        
        
        // find all movies that has at least 3 reviews
        System.out.println("Movie with at least 3 reviews: ");
        //
        // Task 3: your code here
        //        
        System.out.println();
        
		em.close();
		emf.close();
	}
}
