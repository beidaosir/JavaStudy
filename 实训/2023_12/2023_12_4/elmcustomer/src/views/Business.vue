<template>
  <div class="about">

    <van-row>
      <van-col class=""></van-col>
    </van-row>

    <van-card
      num="1000"
      price="起送价：￥20.0"
      desc="非常好吃"
      title="老李家羊肉汤"
      thumb="https://fastly.jsdelivr.net/npm/@vant/assets/ipad.jpeg"
    >
      <template #tags>
        <van-tag plain type="primary">标签</van-tag>
        <van-tag plain type="primary">标签</van-tag>
      </template>
      <template #footer>
        <van-button size="mini">按钮</van-button>
        <van-button size="mini">按钮</van-button>
      </template>
    </van-card>
  </div>
</template>
