<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ descritpion }}</p>

    <section>
      <div
        class="review"
        v-bind:class="{ favorited: review.favorited }"
        v-for="review in reviews"
        v-bind:key="review.id"
      >
        <h4>{{ review.reviewer }}</h4>
        <h3>{{ review.title }}</h3>
        <p>{{ review.review }}</p>
        <div class="rating">
          <img
            src="../assets/star.png"
            v-for="i in review.stars"
            v-bind:key="i"
            class="ratingStar"
          />
        </div>
        <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
      </div>
    </section>
    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? "" : "s " }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? "" : "s " }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? "" : "s " }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? "" : "s " }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? "" : "s " }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Product Review",
  data() {
    return {
      name: "Cigar Party for Dummies",
      description: "Host and plan the perfect cigar party",
      reviews: [
        {
          id: 1,
          reviewer: "Malcom Gladwell",
          title: "What a book",
          review: "It is certainly a book.",
          stars: 3,
          favorited: true,
        },
        {
          id: 2,
          reviewer: "Rick",
          title: "Morty",
          review: "Aw, jeez Rick",
          stars: 3,
          favorited: false,
        },
      ],
    };
  },
  computed: {
    averageRating() {
      const sum = this.reviews.reduce((currSum, review) => {
        return currSum + review.stars;
      }, 0);
      const avg = sum / this.reviews.length;
      return avg;
    },
    numberOfOneStarReviews() {
      return this.reviews.filter((r) => r.stars === 1).length;
    },
    numberOfTwoStarReviews() {
      return this.reviews.filter((r) => r.stars === 2).length;
    },
    numberOfThreeStarReviews() {
      return this.reviews.filter((r) => r.stars === 3).length;
    },
    numberOfFourStarReviews() {
      return this.reviews.filter((r) => r.stars === 4).length;
    },
    numberOfFiveStarReviews() {
      return this.reviews.filter((r) => r.stars === 5).length;
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
  background-color: lightyellow;
}
</style>