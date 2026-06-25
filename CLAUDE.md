# CLAUDE.md

## Git Identity

All commits must be authored and signed by the personal account:

- **name:** sw-samuraj
- **email:** vit.kotacka@gmail.com
- **signing key:** `~/.ssh/id_ed25519.pub`

This is handled automatically via `~/.gitconfig` `includeIf` for `~/projects/guido/`. Do not let the global work identity (`vita-kotacka` / `vit.kotacka@wultra.com`) bleed in.

## GitHub CLI

`gh` must be authenticated as `sw-samuraj` before any issue or PR operations:

```bash
gh auth switch --user sw-samuraj   # if vita-kotacka is currently active
```

## Workflow

1. Create a GitHub issue, assigned to `sw-samuraj`
2. Create a branch: `issue/<number>-<short-description>`
3. Implement the changes
4. Push and open a PR — squash merge only (repo enforces this)

## Branch Protection

`master` has an active ruleset (`master-ruleset`) enforcing:
- No direct pushes — all changes via PR
- Squash-only merges
- Required signed commits

GitHub signs squash commits with its own GPG key, so `gh pr merge --squash` satisfies the signature requirement without any local workaround.

## Repo Map

Each subdirectory implements the same minimal "Hello, world!" HTTP server for benchmarking:

| Directory     | Language | Framework / approach              | Port |
|---------------|----------|-----------------------------------|------|
| `golang/`     | Go 1.26  | stdlib `net/http.ServeMux`        | 8000 |
| `java/`       | Java 25  | JDK stdlib `com.sun.net.httpserver` + virtual threads | 4567 |
| `kotlin/`     | Kotlin   | SparkJava 2.8.0                   | 4567 |
| `rust/`       | Rust     | Hyper 0.12                        | 3000 |
| `clojure/`    | Clojure  | Ring + Jetty adapter              | 3000 |
| `python/`     | Python   | Flask + flask-restful             | 5002 |
| `c/`          | C        | Ulfius                            | 8080 |
| `java-ulfius/`| Java     | GraalVM native + Ulfius (C FFI)   | 8080 |

Benchmark tool used across all examples: **Apache Bench** (`ab`).

## Go LSP

The `gopls-lsp` plugin is installed (Go 1.26, `gopls` v0.22.0). Use the `LSP` tool for symbol lookup, go-to-definition, find-references, etc. on `.go` files.

## Java / Gradle

- **JDK:** 25 (Temurin), managed via SDKMAN — `sdk use java 25.0.3-tem`
- **Build tool:** Gradle 9.6.0, managed via SDKMAN — `sdk use gradle 9.6.0`
- **Build:** `./gradlew jar` (inside `java/`)
- **Run:** `java -jar build/libs/java-rest-service.jar`
- **Stop Gradle daemon:** `./gradlew --stop`
