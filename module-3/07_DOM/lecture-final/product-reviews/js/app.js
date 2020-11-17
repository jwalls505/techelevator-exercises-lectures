const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [{
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review: "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review: "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review: "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review: "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  const productName = pageTitle.querySelector('.name');
  productName.innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  const pageDescription = document.querySelector('.description');
  pageDescription.innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {

  const main = document.getElementById('main');

  reviews.forEach((r) => {
    const reviewContainer = document.createElement('div'); // <div></div>
    reviewContainer.classList.add('review'); // <div class="review"></div>


    // <div class="review">
    //   <h4>Malcom Gladwell</h4>
    // </div>
    addReviewer(reviewContainer, r.reviewer);


    /* <div class="review">
         <h4>Malcom Gladwell</h4>
         <div class="rating">
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
         </div>
      </div> 
    */
    addRating(reviewContainer, r.rating);


    /* <div class="review">
         <h4>Malcom Gladwell</h4>
         <div class="rating">
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
         </div>
         <h3>What a book!</h3>
      </div> 
    */
    addTitle(reviewContainer, r.title);



    /* <div class="review">
         <h4>Malcom Gladwell</h4>
         <div class="rating">
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
          <img alt='star' src='img/star.png'>
         </div>
         <h3>What a book!</h3>
         <p>It is certainly a book. ...</p>
      </div> 
    */
    addReview(reviewContainer, r.review);

    main.insertAdjacentElement('beforeend', reviewContainer);
  });

}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const reviewer = document.createElement('h4'); // <h4></h4>
  reviewer.innerText = name; // <h4>Malcom Gladwell</h4>

  // <div class="review">
  //   <h4>Malcom Gladwell</h4>
  // </div>
  parent.appendChild(reviewer);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  const ratingContainer = document.createElement('div');
  ratingContainer.classList.add('rating'); // <div class="rating"></div>

  for (let i = 0; i < numberOfStars; i++) {
    const star = document.createElement('img');
    star.setAttribute('alt', 'star');
    star.setAttribute('src', 'img/star.png'); // <img alt='star' src='img/star.png'>

    ratingContainer.appendChild(star);
  }

  parent.appendChild(ratingContainer);

  /* <div class="review">
     <!-- whatever else I did earlier -->
     <div class="rating">
      <img alt='star' src='img/star.png'>
      <img alt='star' src='img/star.png'>
      <img alt='star' src='img/star.png'>
     </div>
    </div>
 */

}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const titleContainer = document.createElement('h3');
  titleContainer.innerText = title; // <h3>What a book!</h3>

  parent.appendChild(titleContainer);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewContainer = document.createElement('p');
  reviewContainer.innerText = review; // <p>It is certainly a book. ...</p>

  parent.appendChild(reviewContainer);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();