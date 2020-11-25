<template>
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
      <p>
        Favorite?
        <input
          type="checkbox"
          v-bind:checked="review.favorited"
          v-on:change="onFavoritedChanged(review)"
        />
      </p>
    </div>
  </section>
</template>

<script>
export default {
  computed: {
    filteredList() {
      const reviews = this.$store.state.reviews;
      const numberOfStarsFilter = this.$store.state.numberOfStarsFilter;
      if (numberOfStarsFilter == 0) {
        return reviews;
      }

      return reviews.filter((r) => r.stars === numberOfStarsFilter);
    },
  },
  methods: {
    onFavoritedChanged(review) {
      this.$store.commit("FLIP_FAVORITED", this.review);
    },
  },
};
</script>

<style scoped>
</style>