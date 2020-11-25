<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter">{{ averageRating }}</span>
    Average Rating
  </div>
</template>
<script>
export default {
  computed: {
    averageRating() {
      const reviews = this.$store.state.reviews;
      const sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.stars;
      }, 0);

      const avg = sum / reviews.length;

      return avg.toFixed(2);
    },
  },
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", 0);
    },
  },
};
</script>
<style scoped>
</style>