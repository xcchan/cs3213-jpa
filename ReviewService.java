/**
 * Name   1 :	Edward Chan
 * Matric 1 :	A0097   H
 *
 * Name   2 :	Koh Zheng Kang
 * Matric 2 :	A0097973H
 */

package coolshot;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

public class ReviewService {
    protected EntityManager em;

    public ReviewService(EntityManager em) {
        this.em = em;
    }

    public Review createReview(int id, int score, String comment, Movie mov) {
        
        Review objReview = new Review(id);
        objReview.setScore(score);
        objReview.setComment(comment);
        objReview.setReviewedDate(new Date()); // Set as Now.
        objReview.setMovie(mov);

        em.persist(objReview);
        return objReview;
    }

    public Review removeReview(int id) {
        Review objReview = findReview(id);
        if(objReview!=null) {
        	em.remove(objReview);
        }    
        return objReview;
    }

    public Review findReview(int id) {
        return em.find(Review.class, id);
    }

    public Collection<Review> findAllReviews() {
        Query query = em.createQuery("SELECT r FROM Review r");
        return (Collections<Review>) query.getResultList();
    }
    
    public Collection<Review> findAllReviews(Movie mov) {
    	Query query = em.createQuery("SELECT r FROM Review r WHERE r.movie_id="+mov.getId());
        return (Collections<Review>) query.getResultList();
    }
    
    public Collection<Review> findReviewsByTitle(String title) {
    	Query query = em.createQuery("SELECT r FROM Review r WHERE r.movie.title = '" + title + "'");
        return (Collections<Review>) query.getResultList();
    }
}
