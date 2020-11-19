const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [];
const baseURL = 'http://localhost:8080';

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

function clearReviews() {
  document
    .querySelectorAll('.review')
    .forEach(x => x.remove());
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  clearReviews();
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerHTML = review.reviewer;
  tmpl.querySelector('h3').innerHTML = review.title;
  tmpl.querySelector('p').innerHTML = review.review;

  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);

  const reviewContainers = document.querySelectorAll('.review');
  const lastReviewContainer = reviewContainers[reviewContainers.length - 1];
  lastReviewContainer.querySelector('.deleteReview').addEventListener('click', () => {
    deleteReviewById(lastReviewContainer, review.id);
  });
}

// LECTURE STARTS HERE ---------------------------------------------------------------

/**
 * Take an event on the description and swap out the description for a text box.
 *
 * @param {Element} desc the Element that contains the page description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = desc.innerText;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Element} textBox the text box the user was editing
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
    if (desc.innerText === '') {
      desc.innerHTML = '&nbsp;';
    }
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {
  /*
  1. Get all of the data from the form
  2. Save the data to my array
  3. Call displayReviews again
  */

  const inputName = document.getElementById('name');
  const inputTitle = document.getElementById('title');
  const selectRating = document.getElementById('rating');
  const inputReview = document.getElementById('review');

  const newReview = {
    reviewer: inputName.value,
    title: inputTitle.value,
    stars: selectRating.value,
    review: inputReview.value
  };

  const requestOptions = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: newReview
  };
  showHideForm();
  fetch(`${baseURL}/reviews`, requestOptions)
    .then((response) => {
      return response.json();
    }).then((data) => {
      reviews.push(data); //adding to array
      displayReview(data); //display
    })
    .catch((error) => {

    });
}

/**
 * Delete a review
 */
function deleteReviewById(reviewElement, id) {
  const requestOption = {
    method: 'DELETE'
  };
  fetch(`${baseURL}/reviews/${id}`, requestOption)
    .then(() => {
      reviews = reviews.filter(r => r.reviewId != id);
      reviewElement.remove();
    })

}

/**
 * Add all of the page's event listeners.
 */
function addEventListeners() {
  const descriptionContainer = document.querySelector('p.description');
  descriptionContainer.addEventListener('mouseenter', () => {
    toggleDescriptionEdit(descriptionContainer);
  });

  const inputDesc = document.getElementById('inputDesc');
  inputDesc.addEventListener('mouseleave', () => {
    exitDescriptionEdit(inputDesc, false);
  });
  inputDesc.addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
      exitDescriptionEdit(inputDesc, true);
    }
  });

  const btn = document.getElementById('btnToggleForm');
  btn.addEventListener('click', showHideForm);

  const btnSaveReview = document.getElementById('btnSaveReview');
  btnSaveReview.addEventListener('click', (event) => {
    event.preventDefault();
    saveReview();
  });
}

document.addEventListener('DOMContentLoaded', () => {
  // add event listeners
  addEventListeners();
  // set the product reviews page title
  setPageTitle();
  // set the product reviews page description
  setPageDescription();

  fetch(`${baseURL}/reviews`)
    .then((res) => {
      return res.json();
    })
    .then((data) => {
      // populate empty const review = [];
      reviews = data;
      // display all of the product reviews on our page
      displayReviews();
    });
});
