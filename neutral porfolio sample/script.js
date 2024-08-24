document.addEventListener('DOMContentLoaded', () => {
    // Project Filtering
    const filterButtons = document.querySelectorAll('#filters button');
    const projects = document.querySelectorAll('.project');

    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            const filter = button.getAttribute('data-filter');
            projects.forEach(project => {
                project.classList.remove('active');
                if (filter === 'all' || project.getAttribute('data-category') === filter) {
                    project.classList.add('active');
                }
            });
        });
    });

    // Dark/Light Mode Toggle
    const toggleThemeButton = document.getElementById('toggle-theme');
    const body = document.body;

    toggleThemeButton.addEventListener('click', () => {
        body.classList.toggle('dark-mode');
        toggleThemeButton.textContent = body.classList.contains('dark-mode') ? 'Light Mode' : 'Dark Mode';
    });

    // Form Submission Simulation
    const contactForm = document.getElementById('contact-form');
    const formResponse = document.getElementById('form-response');

    contactForm.addEventListener('submit', (event) => {
        event.preventDefault();
        formResponse.textContent = 'Thank you for your message. I will get back to you soon!';
        contactForm.reset();
    });

    // Section Reveal on Scroll
    const sections = document.querySelectorAll('section');
    const revealSections = () => {
        sections.forEach(section => {
            const sectionTop = section.getBoundingClientRect().top;
            const revealPoint = 150;
            if (sectionTop < window.innerHeight - revealPoint) {
                section.classList.add('active');
            }
        });
    };

    window.addEventListener('scroll', revealSections);
    revealSections(); // Trigger on load
});
