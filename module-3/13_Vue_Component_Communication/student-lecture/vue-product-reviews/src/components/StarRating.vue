<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter">{{
      numberOfStarReviews
    }}</span>
    {{ stars }} Star Review{{ numberOfStarReviews === 1 ? "" : "s" }}
  </div>
</template>

<script>
export default {
  props: ["stars"],
  computed: {
    numberOfStarReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.filter((r) => r.stars === stars).length;
    },
  },
  method: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", this.stars);
    },
  },
};
</script>

<style scoped>
</style>