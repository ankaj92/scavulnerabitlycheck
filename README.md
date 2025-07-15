# SCA \[Snyk + SBOM Integration] - Java + Gradle

## 📘 Overview

This project demonstrates how to integrate **Software Composition Analysis (SCA)** into a Java CI pipeline using **Snyk** for dependency scanning, **Syft** for SBOM generation, and **Grype** for binary-level vulnerability scanning.

> ✅ CI/CD Platform: **GitHub Actions**
> ✅ Build Tool: **Gradle with Wrapper (`./gradlew`)**
> ✅ Languages: **Java 17**

---

## 🎯 Objectives

- Identify known vulnerabilities in open-source dependencies.
- Generate and scan a **Software Bill of Materials (SBOM)**.
- Automate scans in the CI/CD pipeline.
- Upload scan reports as artifacts.

---

## 🧰 Tools Used

| Tool      | Purpose                         |
| --------- | ------------------------------- |
| **Snyk**  | Dependency (source-level) SCA   |
| **Syft**  | SBOM generation (SPDX/JSON)     |
| **Grype** | SBOM-based binary vuln scanning |

---

## 🗂️ Project Structure

````
Assignment4/
└── my-java-project/
    ├── build.gradle
    ├── settings.gradle
    ├── gradlew
    ├── gradlew.bat
    ├── gradle/
    │   └── wrapper/
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── example/
    │   │   │           └── App.java
    │   │   └── resources/
    │   ├── test/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── example/
    │   │   │           └── AppTest.java
    │   │   └── resources/
    ├── reports/
    │   ├── snyk-report.json
    │   ├── sbom.json
    │   ├── sbom.spdx.json
    │   ├── grype-report.json
    │   ├── grype-report.txt
    │   └── grype-report.sarif

---

## ⚙️ GitHub Actions Workflow Highlights

```yaml
- Checkout code
- Set up Java 17
- Build using ./gradlew
- Snyk scan with --all-projects
- Generate SBOM via Syft (JSON, SPDX)
- Scan SBOM with Grype (JSON, SARIF, text)
- Upload all reports as artifacts
````

---

## 📄 Sample Reports

- `snyk-report.json`: Dependency vulnerabilities
- `sbom.json` / `sbom.spdx.json`: SBOM output
- `grype-report.json`, `.txt`, `.sarif`: Vulnerability scan via SBOM

---

## ✅ Recommendations

- Align all projects to **Java 17** for consistent scanning compatibility.
- Use `./gradlew` in CI for reliable cross-platform builds.
- Merge all build outputs into a single folder prior to SBOM generation.
- Use `--all-projects` (not `--file`) with Snyk to support multi-module Gradle builds.
- Keep `continue-on-error: true` in scanning steps to prevent CI blockage.
- Use both **Snyk (source)** and **Grype (binary)** for full security coverage.
- Upload all reports (JSON, SARIF, HTML, SBOM) as GitHub Actions artifacts.
- Enable scheduled scanning for long-term monitoring.

---

## 📌 Conclusion

This CI-integrated SCA pipeline using **Snyk**, **Syft**, and **Grype** empowers Java developers with automated vulnerability detection, complete dependency transparency, and SBOM generation. It aligns with DevSecOps practices by shifting security left and ensuring software supply chain integrity without impacting build workflows.

---

## 📎 References

- [Snyk CLI Docs](https://docs.snyk.io)
- [Anchore Syft](https://github.com/anchore/syft)
- [Anchore Grype](https://github.com/anchore/grype)
- [SBOM Specification (SPDX)](https://spdx.dev/)
