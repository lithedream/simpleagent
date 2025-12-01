# antisocial network
Currently containing the Antisocial Network agent, which is a collection of different personalities replying to the user's query and addressing each other, enabled to use Google search.

The personalities included are

Chad: overly confident and dismissive

Nina: supportive but slightly passive-aggressive

Alex: sarcastic and cynical

Pat:  conspiratorial and paranoid

John: the most grounded, reasoning on all points of view and offering the best reply

# how to run
Copy .env.example to .env and set GOOGLE_API_KEY before running the app.
The CLI reads GOOGLE_API_KEY from your environment at startup.

How to boot the development server with the baked-in Maven profile:

1) Create and source your `.env` if you rely on environment variables:
```bash
source .env
```

2) Build and start the server on port 8000 using the `run-server` profile:
```bash
mvn -Prun-server compile exec:java
```

What the profile does:
- Runs `com.google.adk.web.AdkWebServer`
- Passes `--adk.agents.source-dir=target --server.port=8000` by default
- You can override the args with `-Dadk.args="--server.port=9000"` or the main class with `-Dadk.mainClass=...` if needed.

Requirements: Java 21+ and Maven installed locally.
