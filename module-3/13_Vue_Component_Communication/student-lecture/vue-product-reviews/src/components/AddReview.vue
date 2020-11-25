<template>
  <div>
    <a href="#" v-on:click.prevent="showHideForm">Show Form</a>

    <form
      v-on:submit.prevent="addNewReview"
      v-show="showTheReviewsForm === true"
    >
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
          <option value="2">2 Stars</option>
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
  data() {
    return {
      newReview: {
        reviewer: "",
        title: "",
        stars: 1,
        review: "",
      },
      showTheReviewsForm: false,
    };
  },
  methods: {
    addNewReview() {
      if (this.newReview.reviewer == "" || this.newReview.title == "") {
        return;
      }
      this.$store.commit("ADD_REVIEW", this.newReview);
      this.resetForm();
    },

    resetForm() {
      this.newReview = {
        reviewer: "",
        title: "",
        stars: 1,
        review: "",
      };

      this.showTheReviewsForm = false;
    },

    showHideForm() {
      this.showTheReviewsForm = true;
    },
  },
};
</script>

<style scoped>
</style>