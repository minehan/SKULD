<template>
<div class="over-ray">
  <div class="centering">
    <v-progress-circular
      class="centering"
      :size="300"
      :width="10"
      color="#7fbfff"
      indeterminate
    >
    </v-progress-circular>
  </div>
</div>
</template>

<style scoped>
.over-ray {
  position: relative;
  width: 100%;
  height: 100vh;
  z-index: 10;
}

.centering {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);
}

</style>
