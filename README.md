# Binotify SOAP Service

## 1. Deskripsi

Binotify SOAP Service adalah sevice yang berbentuk SOAP yang dibuat dengan menggunakan JAX-WS, berfungsi untuk melakukan proses subscription dari pengguna Binotify App kepada penyanyi premium. Pada SOAP service ini juga penyanyi premium dapat melakukan penerimaan atau penolakan terhadap permintaan subscription dari pengguna Binotify App.

## 2. Requirements

 - JDK 8
 - Docker

## 3. How to Install

### JDK 8

[Download and Install JDK 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

### Docker

[Download and Install Docker](https://docs.docker.com/get-docker/)

## 4. How to Run Server

```bash
docker compose up --build
```

*Flag* `--build` berfungsi untuk mem-*build image* sebelum eksekusi. Ini dilakukan supaya perubahan yang terjadi pada kode direfleksikan ke hasil tes. Tambahkan *flag* `--detach` untuk *run* di *background*.

- *url*: `localhost:8080/service/subscription`

## 5. Service

Berikut adalah service yang ada di Binotify SOAP Service:
- `acceptSubscription`
- `addSubscription`
- `rejectSubscription`
- `createSubscriptionDatabase`

## 6. Pembagian Tugas

| Fitur  | 13520004 | 13520135 | 13520165 |
| --- | --- | --- | --- |
| Database |  |  | :white_check_mark: |
| Docker  |  | :white_check_mark: |  |
| Security |  | :white_check_mark: |  |
| Menerima Permintaan Subscription dari Binotify App |  |  | :white_check_mark: |
| Menerima Penerimaan / Penolakan Permintaan Subscription |  | :white_check_mark: |  |
| Endpoint Check Status Permintaan (Unimplemented) | :white_check_mark: |  |  |
| Cache |  | :white_check_mark: |  |

## 7. Anggota Kelompok

| Nama  | NIM |
| --- | --- |
| Gede Prasidha Bhawarnawa | 13520004 |
| Muhammad Alif Putra Yasa   | 13520135 |
| Ghazian Tsabit Alkamil   | 13520165 |