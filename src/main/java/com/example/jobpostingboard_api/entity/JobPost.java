package com.example.jobpostingboard_api.entity;
import com.example.jobpostingboardapi.enums.JobStatus;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class JobPost{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "location")
    private String location;

    @Column(name = "salary")
    private String salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "jobStatus")
    private JobStatus status;

    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;


    @OneToMany(mappedBy = "jobPost")
    private Set<Application> jobApplications = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }


}