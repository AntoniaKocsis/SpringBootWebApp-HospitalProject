# Hospital  Management Project

### Spring Boot with IntelliJ IDEA, MySQL, JPA, Hibernate, Thymeleaf and Bootstrap

## Entities:

###  Patients
####  - Attributes
    private String firstName
    private String lastName
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime birthDate
    private String contact
    private String address
####  - Relationships
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Admission> admissions;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PatientNotificationSystem> patientNotificationSystems;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LabTestResult> labTestResults;

###  Doctors
####  - Attributes
    private String firstName;
    private String lastName;
    private String contact;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime birthDate;
    private boolean onCall;

####  - Relationships
    @ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY)
    private List<Department> departments;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Admission> admissions;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DoctorDashboard> doctorDashboards;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;
###  Appointments
#### - Attributes
    private Patient patient;

    private Doctor doctor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    private ExaminationRoom examinationRoom;

#### - Relationships
    // Appointment - Patient Relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Appointment - Doctor Relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // Appointment - ExaminationRoom Relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id", nullable = false)
    private ExaminationRoom examinationRoom;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "appointment_observer",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "observer_id")
    )
    private List<Observer> observers;
###  Admissions
#### - Attributes
    private Patient patient;

    private Doctor doctor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime enrollmentDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dischargingDate;

    private AdmissionRoom admissionRoom;
#### - Relationships

    // Patient - Admission Relationship
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;


    // Doctor - Admission Relationship

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;


    // AdmissionRoom - Admission Relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_id", nullable = false)
    private AdmissionRoom admissionRoom;
###  Departments
#### - Attributes
#### - Relationships

###  Hospital Rooms
#### - Attributes
#### - Relationships

###  Emergency Room
###  Billing System
###  Prescriptions
#### - Attributes
#### - Relationships

###  Medications
#### - Attributes
    private int concentration;
    private String name;
#### - Relationships
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "medications")
    private List<Prescription> prescriptions;

###  Lab Test Results
#### - Attributes
    private Patient patient;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")

    private LocalDateTime date;

    private String result;

    private String testName;
#### - Relationships
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
