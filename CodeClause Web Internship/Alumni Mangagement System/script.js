const alumniTable = document.getElementById('alumniTable');

function addAlumni() {
    const name = document.getElementById('name').value;
    const batch = document.getElementById('batch').value;
    const email = document.getElementById('email').value;

    if (name.trim() === '' || batch.trim() === '' || email.trim() === '') {
        alert('Please enter all fields.');
        return;
    }

    const row = document.createElement('tr');
    row.innerHTML = `
    <td>${name}</td>
    <td>${batch}</td>
    <td>${email}</td>
    <td class="actions">
      <button onclick="editAlumni(this)">Edit</button>
      <button onclick="deleteAlumni(this)">Delete</button>
    </td>
  `;
    alumniTable.appendChild(row);

    clearInputs();
}

function editAlumni(button) {
    const row = button.parentElement.parentElement;
    const name = row.children[0].textContent;
    const batch = row.children[1].textContent;
    const email = row.children[2].textContent;

    document.getElementById('name').value = name;
    document.getElementById('batch').value = batch;
    document.getElementById('email').value = email;

    alumniTable.removeChild(row);
}

function deleteAlumni(button) {
    const row = button.parentElement.parentElement;
    alumniTable.removeChild(row);
}

function searchAlumni() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const rows = alumniTable.getElementsByTagName('tr');

    for (let i = 1; i < rows.length; i++) {
        const row = rows[i];
        const name = row.children[0].textContent.toLowerCase();
        const batch = row.children[1].textContent.toLowerCase();

        if (name.includes(searchInput) || batch.includes(searchInput)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    }
}

function clearInputs() {
    document.getElementById('name').value = '';
    document.getElementById('batch').value = '';
    document.getElementById('email').value = '';
}
