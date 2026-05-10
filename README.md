🛒 E‑commerce Search Application
-----------------------------

A production‑ready e‑commerce backend service built using Java 25, Spring Boot 4.0, MongoDB, and Elasticsearch.
The application uses MongoDB as the system of record for all product data and Elasticsearch as a dedicated search index to provide fast, scalable, and flexible search capabilities.

🚀 Features
------------------------
✅ Create new products (persisted in MongoDB)
🔍 Search products by name using Elasticsearch
📦 Retrieve all products from MongoDB
✏️ Update existing product details (MongoDB → Elasticsearch sync)
🗑️ Delete products (MongoDB + index cleanup in Elasticsearch)
⚡ High‑performance full‑text search powered by Elasticsearch
🧱 Clean layered architecture (Controller, Service, Repository)
https://github.com/user-attachments/assets/a5cf520d-5ae1-4b9c-bca5-7f2d15312d40

🏗️ Tech Stack
---------

Java 25
Spring Boot 4.0
Spring Data MongoDB
Spring Data Elasticsearch
MongoDB (Primary Database)
Elasticsearch 9.x (Search Engine)
Gradle
REST APIs


🧠 Architecture Overview
-----------
Controller Layer
        ↓
Service Layer
        ↓
MongoDB Repository (Primary Data Store)
        ↓
Elasticsearch Search Index (Derived Read Model)

Responsibilities
--------------
-----Controller Layer

Exposes REST APIs for product management and search operations.

-------Service Layer

Contains business logic and coordinates data flow:

Writes to MongoDB

Indexes data into Elasticsearch


------MongoDB Repository


Acts as the source of truth

Handles all CRUD operations

Ensures data consistency


-----Elasticsearch Repository


Stores a search‑optimized projection of product data

Enables fast full‑text search, filtering, and relevance ranking

Can be safely rebuilt from MongoDB data at any time


✅ Architectural Principles
--------------

MongoDB is the authoritative datastore

Elasticsearch is a derived, read‑optimized search index

Data is written to MongoDB first, then indexed into Elasticsearch

Elasticsearch is never used for transactions or persistence

This design follows CQRS / Polyglot Persistence best practices
