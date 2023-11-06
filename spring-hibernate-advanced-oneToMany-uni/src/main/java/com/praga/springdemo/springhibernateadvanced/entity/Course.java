package com.praga.springdemo.springhibernateadvanced.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private  String title;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    
    @OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)  
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    

    public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		if(this.reviews == null) {
			this.reviews = new ArrayList<Review>();
		}
		this.reviews.add(review);
		review.setCourse(this);
	}

	@Override
    public String toString() {
        return "Courses{" +
                "title='" + title + '\'' +
                '}';
    }
}
