#!/bin/bash

echo "Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-14T10:00:00.000Z&productId=35455&brandId=1'
echo

echo "Test 2: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-14T16:00:00.000Z&productId=35455&brandId=1'
echo

echo "Test 3: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-14T21:00:00.000Z&productId=35455&brandId=1'
echo

echo "Test 4: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-15T10:00:00.000Z&productId=35455&brandId=1'
echo

echo "Test 5: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-16T21:00:00.000Z&productId=35455&brandId=1'
echo

echo "Test 6: Petición donde no existe un precio para los datos enviados"
curl -X GET 'http://localhost:8080/api/v1/price?applicationDate=2020-06-16T21:00:00.000Z&productId=35455&brandId=11'
echo