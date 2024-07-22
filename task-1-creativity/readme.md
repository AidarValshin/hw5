# Задание 1. Творческое

Придумайте и напишите (словами) пример использования (в каких случаях вы бы его использовали) каждого из стандартных пулов потоков:

* FixedThreadPool;
* CachedThreadPool;
* SingleThreadExecutor;
* ScheduledExecutorService;
* ForkJoinPool.

## FixedThreadPool

```text
Очень много коротких по времени задач( CPU COUNT* N)

```

## CachedThreadPool

```text
Количество задач постоянно и сравнимо с количеством потоков

```

## SingleThreadExecutor

```text
Используется несколько объектов синхронизации, нужна сильная линеаризация

```

## ScheduledExecutorService

```text
Таски по времени

```

## ForkJoinPool

```text
Рекурсивные вычисления с передачей вычисленного результтата дальше

```

