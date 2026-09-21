# 🔍 Duplicate File Finder

A lightweight command-line tool built with **Java 21** that recursively scans a directory and finds duplicate files based on their content.

## ✨ Features

* Recursively scans directories
* Groups files by size before hashing
* Uses **SHA-256** to compare file contents
* Streams files instead of loading entire files into memory
* Supports files with different names and locations
* Simple CLI interface

## 🏗️ How It Works

The application uses a two-stage filtering strategy:

```text
Directory
    ↓
Scan files
    ↓
Group by file size
    ↓
Remove unique sizes
    ↓
Calculate SHA-256
    ↓
Group by hash
    ↓
Remove unique hashes
    ↓
Duplicate files
```

Files with different sizes cannot be identical, so hashing is only performed on files that share the same size.

## 🚀 Getting Started

### Requirements

* Java 21+
* Maven 3.9+

### Build

```bash
mvn clean package
```

### Run

Windows:

```powershell
java -cp target\classes nvb.dev.duplicatefilefinder.DuplicateFileFinderApp "C:\path\to\directory"
```

Linux/macOS:

```bash
java -cp target/classes nvb.dev.duplicatefilefinder.DuplicateFileFinderApp "/path/to/directory"
```

### Example

```text
Scanning directory: C:\Users\erfan\Desktop\Test\files

Duplicate groups:
[C:\Users\erfan\Desktop\Test\files\file1.txt,
 C:\Users\erfan\Desktop\Test\files\file2.txt,
 C:\Users\erfan\Desktop\Test\files\file3.txt]
```

## 🧰 Technology

* **Java 21**
* **Maven**
* Java NIO (`Path`, `Files`)
* SHA-256 (`MessageDigest`)
* Java Streams

## 👤 Author

**Erfan**

[GitHub](https://github.com/erfannvb?utm_source=chatgpt.com)
