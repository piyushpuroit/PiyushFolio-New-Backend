package com.piyush.portfoliobackend.config;

import com.piyush.portfoliobackend.entity.*;
import com.piyush.portfoliobackend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;
    private final CertificationRepository certificationRepository;
    private final ResumeRepository resumeRepository;
    private final SocialLinkRepository socialLinkRepository;

    public DatabaseSeeder(ProjectRepository projectRepository,
                          SkillRepository skillRepository,
                          EducationRepository educationRepository,
                          ExperienceRepository experienceRepository,
                          CertificationRepository certificationRepository,
                          ResumeRepository resumeRepository,
                          SocialLinkRepository socialLinkRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
        this.educationRepository = educationRepository;
        this.experienceRepository = experienceRepository;
        this.certificationRepository = certificationRepository;
        this.resumeRepository = resumeRepository;
        this.socialLinkRepository = socialLinkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedResume();
        seedProjects();
        seedSkills();
        seedEducation();
        seedExperiences();
        seedCertifications();
        seedSocialLinks();
    }

    private void seedResume() {
        Resume resume = resumeRepository.findById(1L).orElse(new Resume());
        resume.setId(1L);
        resume.setDownloadUrl("/Piyush_Purohit_Resume.pdf");
        resumeRepository.save(resume);
        System.out.println("Seeded/updated resume metadata.");
    }

    private void seedProjects() {
        boolean hasLocalImages = projectRepository.findAll().stream()
                .anyMatch(p -> p.getImageUrl() != null && p.getImageUrl().startsWith("/"));
        if (projectRepository.count() < 4 || hasLocalImages) {
            projectRepository.deleteAll();
            Project p1 = Project.builder()
                    .title("Hospitality Management Platform")
                    .shortDescription("Architected a real-time booking ecosystem featuring a modern, responsive UI and a highly scalable backend to streamline complex hotel operations.")
                    .longDescription("End-to-end billing and POS system for hospitality businesses\nReal-time order and table management dashboard\nRole-based access for staff and admin\nInvoice generation with GST compliance\nIntegrated team and inventory management module")
                    .technologies("React,Tailwind CSS,Node.js,MySQL,REST API,React Native")
                    .githubUrl("https://github.com/piyushpuroit/Billing-pos")
                    .liveUrl("https://trivanahospitality.com/team")
                    .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80")
                    .featured(true)
                    .displayOrder(1)
                    .build();

            Project p2 = Project.builder()
                    .title("Fitness Playground Website")
                    .shortDescription("Engineered a visually immersive, gamified fitness platform. Designed completely in Figma and brought to life with high-performance vanilla web technologies.")
                    .longDescription("Interactive workout planner with custom routine builder\nExercise library with animated visual guides\nProgress tracking with visual charts and streaks\nResponsive design optimised for mobile-first use\nNo login required — instant access for users")
                    .technologies("HTML5,CSS3,JavaScript,Figma")
                    .githubUrl("https://github.com/piyushpuroit")
                    .liveUrl("#")
                    .imageUrl("https://images.unsplash.com/photo-1517838277536-f5f99be501cd?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80")
                    .featured(true)
                    .displayOrder(2)
                    .build();

            Project p3 = Project.builder()
                    .title("Java Swing Resume Builder")
                    .shortDescription("Developed a robust Java Swing desktop application that automates the generation, formatting, and structural validation of professional resumes.")
                    .longDescription("Drag-and-drop resume builder with live preview\nMultiple ATS-friendly templates\nExport to PDF with one click\nReal-time editing with section reordering\nClean, professional output without watermarks")
                    .technologies("Java,Swing,OOP,I/O")
                    .githubUrl("https://github.com/piyushpuroit/JavaSwing-Resume-Builder")
                    .liveUrl("#")
                    .imageUrl("https://images.unsplash.com/photo-1586281380349-632531db7ed4?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80")
                    .featured(false)
                    .displayOrder(3)
                    .build();

            Project p4 = Project.builder()
                    .title("Personal Portfolio")
                    .shortDescription("A fast, smooth, and visually unique personal portfolio website with custom animations, custom cursor, and dynamic theme.")
                    .longDescription("Dynamic light/dark theme with custom aesthetic toggles\nSeamless scroll animations using Framer Motion\nInteractive custom cursor and tailored cursor states\nHighly responsive mobile-first UI with Tailwind CSS\nOptimized performance and fast load times with Vite")
                    .technologies("React,Tailwind CSS,Framer Motion,Vite")
                    .githubUrl("https://github.com/piyushpuroit")
                    .liveUrl("https://piyushport-folio.netlify.app/")
                    .imageUrl("https://images.unsplash.com/photo-1507238691740-187a5b1d37b8?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80")
                    .featured(false)
                    .displayOrder(4)
                    .build();

            projectRepository.saveAll(List.of(p1, p2, p3, p4));
            System.out.println("Seeded projects data.");
        }
    }

    private void seedSkills() {
        if (skillRepository.count() == 0) {
            // Programming Languages
            skillRepository.save(Skill.builder().name("Java").category("Programming Languages").proficiencyLevel("Expert").displayOrder(1).build());
            skillRepository.save(Skill.builder().name("C").category("Programming Languages").proficiencyLevel("Intermediate").displayOrder(2).build());
            skillRepository.save(Skill.builder().name("C++").category("Programming Languages").proficiencyLevel("Intermediate").displayOrder(3).build());

            // Web Technologies
            skillRepository.save(Skill.builder().name("HTML5").category("Web Technologies").proficiencyLevel("Expert").displayOrder(4).build());
            skillRepository.save(Skill.builder().name("CSS3").category("Web Technologies").proficiencyLevel("Expert").displayOrder(5).build());
            skillRepository.save(Skill.builder().name("JavaScript (ES6+)").category("Web Technologies").proficiencyLevel("Expert").displayOrder(6).build());

            // Frameworks & Libraries
            skillRepository.save(Skill.builder().name("React.js").category("Frameworks & Libraries").proficiencyLevel("Expert").displayOrder(7).build());
            skillRepository.save(Skill.builder().name("Next.js").category("Frameworks & Libraries").proficiencyLevel("Intermediate").displayOrder(8).build());
            skillRepository.save(Skill.builder().name("Express.js").category("Frameworks & Libraries").proficiencyLevel("Intermediate").displayOrder(9).build());
            skillRepository.save(Skill.builder().name("Tailwind CSS").category("Frameworks & Libraries").proficiencyLevel("Expert").displayOrder(10).build());
            skillRepository.save(Skill.builder().name("Bootstrap").category("Frameworks & Libraries").proficiencyLevel("Intermediate").displayOrder(11).build());
            skillRepository.save(Skill.builder().name("Java Swing").category("Frameworks & Libraries").proficiencyLevel("Intermediate").displayOrder(12).build());

            // Database
            skillRepository.save(Skill.builder().name("MySQL").category("Database").proficiencyLevel("Expert").displayOrder(13).build());
            skillRepository.save(Skill.builder().name("MongoDB").category("Database").proficiencyLevel("Intermediate").displayOrder(14).build());

            // Tools & DevOps
            skillRepository.save(Skill.builder().name("Git").category("Tools & DevOps").proficiencyLevel("Expert").displayOrder(15).build());
            skillRepository.save(Skill.builder().name("GitHub").category("Tools & DevOps").proficiencyLevel("Expert").displayOrder(16).build());
            skillRepository.save(Skill.builder().name("Docker").category("Tools & DevOps").proficiencyLevel("Intermediate").displayOrder(17).build());
            skillRepository.save(Skill.builder().name("Postman").category("Tools & DevOps").proficiencyLevel("Expert").displayOrder(18).build());
            skillRepository.save(Skill.builder().name("Figma").category("Tools & DevOps").proficiencyLevel("Intermediate").displayOrder(19).build());
            skillRepository.save(Skill.builder().name("VS Code").category("Tools & DevOps").proficiencyLevel("Expert").displayOrder(20).build());

            // Concepts
            skillRepository.save(Skill.builder().name("Data Structures & Algorithms").category("Concepts").proficiencyLevel("Expert").displayOrder(21).build());
            skillRepository.save(Skill.builder().name("Object-Oriented Programming").category("Concepts").proficiencyLevel("Expert").displayOrder(22).build());
            skillRepository.save(Skill.builder().name("REST APIs").category("Concepts").proficiencyLevel("Expert").displayOrder(23).build());
            skillRepository.save(Skill.builder().name("Agile").category("Concepts").proficiencyLevel("Intermediate").displayOrder(24).build());
            skillRepository.save(Skill.builder().name("Responsive Design").category("Concepts").proficiencyLevel("Expert").displayOrder(25).build());
            skillRepository.save(Skill.builder().name("Debugging").category("Concepts").proficiencyLevel("Expert").displayOrder(26).build());
            skillRepository.save(Skill.builder().name("Cross-Browser Compatibility").category("Concepts").proficiencyLevel("Expert").displayOrder(27).build());

            System.out.println("Seeded skills data.");
        }
    }

    private void seedEducation() {
        if (educationRepository.count() == 0) {
            Education ed1 = Education.builder()
                    .institution("Engineering College Bikaner")
                    .degree("Computer Science & Engineering")
                    .fieldOfStudy("College (B.Tech)")
                    .grade("CGPA: 9.33 / 10 (up to 5th Sem)")
                    .startDate("2023")
                    .endDate("2027")
                    .description("Student Activity Cell Member — core organizer for college events\nActive participant in technical and cultural fests\nParticipated in multiple Hackathons (ideation + coding rounds)\nPitched startup ideas in pitching rounds/competitions\nCurrently building and working on our own startup (present)")
                    .displayOrder(1)
                    .build();

            Education ed2 = Education.builder()
                    .institution("Bharti Niketan School")
                    .degree("Class/School Topper")
                    .fieldOfStudy("Higher Secondary (12th)")
                    .grade("Score: 98.80%")
                    .startDate("2020")
                    .endDate("2021")
                    .description("Maintained top rank with distinction\nRepresented school in inter-school competitions")
                    .displayOrder(2)
                    .build();

            Education ed3 = Education.builder()
                    .institution("Adarsh Vidya Mandir")
                    .degree("School Topper")
                    .fieldOfStudy("Secondary (10th)")
                    .grade("Score: 93.17%")
                    .startDate("2018")
                    .endDate("2019")
                    .description("Consistent academic topper throughout secondary school\nActively participated in sports and extracurricular activities\nStudent Community President — led school-level events and student initiatives\nMain Anchor (English) at Annual Function — hosted the flagship school event")
                    .displayOrder(3)
                    .build();

            educationRepository.saveAll(List.of(ed1, ed2, ed3));
            System.out.println("Seeded education data.");
        }
    }

    private void seedExperiences() {
        if (experienceRepository.count() == 0) {
            Experience ex1 = Experience.builder()
                    .company("Trivana Hospitality")
                    .position("Chief Frontend Officer & Full Stack Developer")
                    .location("Remote/Bikaner")
                    .startDate("June 2025")
                    .endDate("Present")
                    .current(true)
                    .description("Created the BookTrivana app using React Native, utilizing the same backend as the website (https://booktrivana.com/).\nWorked on POS billing and other core sections of our startup as Chief Frontend Officer.\nLeading frontend development for a hospitality management platform.\nBuilding reusable UI components with React and Tailwind CSS.\nIntegrating REST APIs for booking workflows.\nImproving platform performance and scalability.")
                    .displayOrder(1)
                    .build();

            Experience ex2 = Experience.builder()
                    .company("Codsoft")
                    .position("Frontend Developer Intern")
                    .location("Remote")
                    .startDate("May 2024")
                    .endDate("June 2024")
                    .current(false)
                    .description("Developed responsive web apps including a calculator and various landing pages.\nImplemented seamless cross-browser compatibility.\nUtilized Git and GitHub for team version control.")
                    .displayOrder(2)
                    .build();

            experienceRepository.saveAll(List.of(ex1, ex2));
            System.out.println("Seeded experience data.");
        }
    }

    private void seedCertifications() {
        boolean hasGate = certificationRepository.findAll().stream()
                .anyMatch(c -> c.getName().contains("GATE"));
        boolean hasOldUrl = certificationRepository.findAll().stream()
                .anyMatch(c -> c.getName().contains("GATE") && !c.getCredentialUrl().contains("media.licdn.com"));
        if (certificationRepository.count() == 0 || !hasGate || hasOldUrl) {
            certificationRepository.deleteAll();
            // First certification: GATE CSE 2026 Qualified
            Certification c1 = Certification.builder()
                    .name("GATE CSE 2026 Qualified")
                    .issuingOrganization("IIT (GATE)")
                    .issueDate("2026")
                    .credentialId("GATE Score: 423")
                    .credentialUrl("https://media.licdn.com/dms/image/v2/D5622AQGC5-SX-PJrXA/feedshare-shrink_1280/B56Z1CC69OIMAM-/0/1774929555716?e=1784764800&v=beta&t=HRGaeNPDFsCwXHn771hiOt2x6zlxcI_0A3mjICPCPWs")
                    .displayOrder(1)
                    .build();

            Certification c2 = Certification.builder()
                    .name("Winner – CCC Hackathon 2024")
                    .issuingOrganization("CCC")
                    .issueDate("2024")
                    .credentialId("UI/UX Designer & Team Representative")
                    .credentialUrl("https://github.com/piyushpuroit")
                    .displayOrder(2)
                    .build();

            certificationRepository.saveAll(List.of(c1, c2));
            System.out.println("Seeded certifications/achievements data.");
        }
    }

    private void seedSocialLinks() {
        if (socialLinkRepository.count() == 0) {
            SocialLink sl1 = SocialLink.builder()
                    .platformName("GitHub")
                    .url("https://github.com/piyushpuroit")
                    .icon("GitHub")
                    .displayOrder(1)
                    .build();

            SocialLink sl2 = SocialLink.builder()
                    .platformName("LinkedIn")
                    .url("https://www.linkedin.com/in/piyush-purohit-qs5474/")
                    .icon("LinkedIn")
                    .displayOrder(2)
                    .build();

            SocialLink sl3 = SocialLink.builder()
                    .platformName("Instagram")
                    .url("https://www.instagram.com/piyush._.peeyush/")
                    .icon("Instagram")
                    .displayOrder(3)
                    .build();

            socialLinkRepository.saveAll(List.of(sl1, sl2, sl3));
            System.out.println("Seeded social links data.");
        }
    }
}
