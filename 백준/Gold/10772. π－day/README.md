# [Gold V] π-day - 10772 

[문제 링크](https://www.acmicpc.net/problem/10772) 

### 성능 요약

메모리: 77764 KB, 시간: 168 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2024년 3월 30일 00:26:24

### 문제 설명

<p>You may know that March 14 is known as “π-day”, since 3.14 (which is the third month and fourteenth day) is a good approximation of π.</p>

<p>Mathematicians celebrate this day by eating pie.</p>

<p>Suppose that you have n pieces of pie, and k people who are lined up for pieces of pie. All n pieces of pie will be given out. Each person will get at least one piece of pie, but mathematicians are a bit greedy at times. So, they always get at least as many of pieces of pie as the person in front of them.</p>

<p>For example, if you have 8 pieces of pie and 4 people in line, you could give out pieces of pie in the following five ways (with the first person in line being the first number in the list): [1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2].</p>

<p>Notice that if k = n, there is only one way to give out the pieces of pie: every person gets exactly one piece. Also, if k = 1, there is only one way to give out the pieces of pie: that single person gets all the pieces.</p>

<p>Write a program that determines the number of ways that the pieces of pie can be given out.</p>

### 입력 

 <p>The first line of input is the integer number of pieces of pie, n (1 ≤ n ≤ 250). The second line of input is the integer k which is the number of people in line (1 ≤ k ≤ n).</p>

<p>For at least 20% of the marks for this problem, n ≤ 9. For at least 50% of the marks for this problem, n ≤ 70. For at least 85% of the marks for this problem, n ≤ 120.</p>

### 출력 

 <p>The output will consist of a single integer which is the number of ways that the pieces of pie can be distributed. The output is guaranteed to be less that 2<sup>31</sup>.</p>

