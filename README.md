# Codely Security Test Fixture — Java

This repository is an intentionally vulnerable, non-production Java project for validating source-code security auditing tools such as Codely.

## Purpose

The repository contains exactly four primary security test cases:

1. **SQL Injection** — `SqlInjectionExample.java`
2. **PII in Logs** — `PiiLoggingExample.java`
3. **Java Path Traversal** — `PathTraversalExample.java`
4. **Hardcoded Secret** — `HardcodedSecretExample.java`

The hardcoded credential is deliberately fake and non-functional. No real credentials, network calls, destructive operations, or exploit payloads are included.

## Expected Codely behavior

When this repository is audited, Codely should:

- Fetch this exact GitHub repository and resolve the exact commit SHA.
- Detect **Java** as the source language.
- Not report TypeScript findings because this repository contains no `.ts` source files.
- Report findings that point only to files that actually exist in this repository.
- Report line numbers that exist in the corresponding source revision.
- Ground snippets/evidence in the actual source files.
- Associate each finding with the applicable rule/analyzer.
- Persist findings from the audit result and display the same findings in the UI.

## Important integrity test

The most important test is that every finding is traceable to the audited source revision:

`Repository → Commit SHA → File → Line → Source Evidence → Finding`

If Codely produces a finding for a nonexistent file, a `.ts` file, an invalid line number, or source content that does not exist in the repository, the audit integrity validation should fail rather than generating or displaying a sample finding.

## Project structure

```text
codely-security-test-java/
├── pom.xml
├── README.md
└── src/main/java/com/codely/securitytest/
    ├── SqlInjectionExample.java
    ├── PiiLoggingExample.java
    ├── PathTraversalExample.java
    └── HardcodedSecretExample.java
```

## Safety notice

This project exists only as a controlled security-testing fixture. The vulnerable patterns are intentionally simple so static and semantic analyzers can identify them. Do not deploy this project or reuse the vulnerable patterns in production software.
