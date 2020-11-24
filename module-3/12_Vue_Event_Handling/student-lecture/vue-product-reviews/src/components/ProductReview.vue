<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <section>
      <div
        class="review"
        v-bind:id="review.id"
        v-bind:class="{ favorited: review.favorited }"
        v-for="review in filteredList"
        v-bind:key="review.id"
      >
        <h4>{{ review.reviewer }}</h4>
        <div class="rating">
          <img
            src="../assets/star.png"
            v-for="i in review.stars"
            v-bind:key="i"
            class="ratingStar"
          />
        </div>
        <h3>{{ review.title }}</h3>
        <p>{{ review.review }}</p>
        <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
      </div>
    </section>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="numberOfStarFilter == 0">{{
          averageRating
        }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="numberOfStarsFilter = 1">{{
          numberOfOneStarReviews
        }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="numberOfStarsFilter = 2">{{
          numberOfTwoStarReviews
        }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="numberOfStarsFilter = 3">{{
          numberOfThreeStarReviews
        }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="numberOfStarsFilter = 4">{{
          numberOfFourStarReviews
        }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="numberOfStarsFilter = 5">{{
          numberOfFiveStarReviews
        }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? "" : "s" }}
      </div>
    </div>
    <a href="#" v-on.:click.prevent="showHideForm">Show Form</a>
    <form v-on:submit.prevent="addNewReview" v-if="showForm == true">
      <div class="form-element">
        <label for="reviewer">Reviewer: </label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title: </label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="stars">Rating: </label>
        <select id="stars" v-model.number="newReview.stars">
          <option value="1">1 Star</option>
          <option value="2">Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review: </label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <button type="submit">Save</button>
      <button v-on:click.prevent="resetForm">Cancel</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "Product Review",

  data() {
    return {
      showForm: false,
      name: "Cigar Party for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrel friends",
      reviews: [
        {
          id: 1,
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review: "It is certainly a book.",
          stars: 3,
          favorited: true,
        },
        {
          id: 2,
          reviewer: "Walt Impellicceiri",
          title: "Best book ever!",
          review: "Literally the best book ever guys!",
          stars: 5,
          favorited: false,
        },
      ],
      newReview: {
        reviewer: "",
        title: "",
        review: "",
        stars: 1,
      },
      numberOfStarsFilter: 1,
    };
  },

  computed: {
    averageRating() {
      const sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.stars;
      }, 0);

      const avg = sum / this.reviews.length;

      return avg.toFixed(2);
    },

    numberOfOneStarReviews() {
      return this.numberOfStarReviews(1);
    },

    numberOfTwoStarReviews() {
      return this.reviews.numberOfStarReviews(2);
    },

    numberOfThreeStarReviews() {
      return this.numberOfStarReviews(3);
    },

    numberOfFourStarReviews() {
      return this.numberOfStarReviews(4);
    },

    numberOfFiveStarReviews() {
      return this.numberOfStarReviews(5);
    },
    filteredList() {
      if (this.numberOfStarsFilter == 0) {
        return this.reviews;
      }
      return this.reviews.filter((r) => r.stars === this.numberOfStarsFilter);
    },
  },
  methods: {
    numberOfStarReviews(howManyStars) {
      return this.reviews.filter((r) => r.stars === howManyStars).length;
    },
    addNewReview() {
      this.reviews.push(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.newReview = {
        reviewer: "",
        title: "",
        review: "",
        stars: 1,
      };
      this.showHideForm = false;
    },
    showHideForm() {
      this.showForm = true;
    },
  },
};
</script>

<style scoped>
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

.favorited {
  background-color: lightgreen;
}
</style>