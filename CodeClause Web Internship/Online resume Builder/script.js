function generateResume() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const about = document.getElementById('about').value;
    const experience = document.getElementById('experience').value;
    const education = document.getElementById('education').value;

    const resumeHTML = `
      <h2>${name}</h2>
      <p>Email: ${email}</p>
      <p>Phone: ${phone}</p>
      <h3>About Me:</h3>
      <p>${about}</p>
      <h3>Experience:</h3>
      <p>${experience}</p>
      <h3>Education:</h3>
      <p>${education}</p>
    `;

    const resumeDiv = document.getElementById('resume');
    resumeDiv.innerHTML = resumeHTML;
    resumeDiv.style.display = 'block';
}
