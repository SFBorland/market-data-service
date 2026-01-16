### Who updates Redis
Single Redis writer
- Use case:
  - MDS local cache warmup
- A single MDS instance updates Redis
  - Use Redis SETNX with TTL
  - If a leader dies, another instance acquires leadership
