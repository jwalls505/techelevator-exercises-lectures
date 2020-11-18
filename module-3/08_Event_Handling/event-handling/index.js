
const myList = document.querySelector('ul');

const listItems = document.querySelectorAll('li');

function changeColorOfElement(element) {
  element.style.backgroundColor = element.innerText;
}

function clearColor(element) {
  element.style.backgroundColor = 'white';
}

function addItemToList() {
  const newItem = document.createElement('li');
  newItem.innerText = 'Orange';
  myList.appendChild(newItem);
}

function addEvents() {
  // listItems.forEach(item => {
  myList.addEventListener('click', (event) => {
    console.log('coloring it in.');

    changeColorOfElement(event.target);
    event.stopPropagation();
  });

  // });


  const container = document.getElementById('container');
  container.addEventListener('click', (event) => {

    console.log('clearing it out.');
    myList.children.forEach((item) => {
      clearColor(item);
    });

  });
}

addItemToList();

addEvents();

