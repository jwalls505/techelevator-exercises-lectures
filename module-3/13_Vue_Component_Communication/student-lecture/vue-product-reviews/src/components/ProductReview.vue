<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <review-list  />

    <div class="well-display">
      <average-summary  />
      <star-rating v-bind:stars="1" />
      <star-rating v-bind:stars="2"  />
      <star-rating v-bind:stars="3"  />
      <star-rating v-bind:stars="4"  />
      <star-rating v-bind:stars="5" />
    </div>

   <add-review />
</template>

<script>
import ReviewList from "./ReviewList.vue";
import StarRating from "./StarRating.vue";
import AverageSummary from "./AverageSummary.vue";
import AddReview from "./AddReview.vue";
export default {
  name: "Product Review",

  data() {
    return {
      name: "Cigar Party for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrel friends",
    };
  },

  computed: {
    StarRating,
    AverageSummary,
    ReviewList,
    AddReview,
  },
};
</script>

<style>
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