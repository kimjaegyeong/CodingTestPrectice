//https://www.acmicpc.net/problem/8452
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 1010
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct Edge{
    int x, y, dead;
} e[100001];

struct Query{
    char t;
    int p, res;
} q[200001];

int N, M, Q, dist[MX];
vector<int> gph[MX];

void update(int S){
    queue<int> q;
    q.push(S);
    while(!q.empty()){
        int now = q.front(); q.pop();
        for(const auto& next: gph[now]){
            if(dist[next] > dist[now] + 1){
                dist[next] = dist[now] + 1;
                q.push(next);
            }
        }
    }
}

int main() {
    fastio;
    
    cin >> N >> M >> Q;
    for(int i = 1; i <= M; i++) cin >> e[i].x >> e[i].y;
        
    for(int i = 1; i <= Q; i++){
        cin >> q[i].t >> q[i].p;
        if(q[i].t == 'U') e[q[i].p].dead = true;
    }
    
    for(int i = 1; i <= M; i++)
    if(!e[i].dead) gph[e[i].x].push_back(e[i].y);
    
    fill(dist, dist + N + 1, 1e9);
    dist[1] = 0;
    update(1);
    
    for(int i = Q; i; i--){
        if(q[i].t == 'U'){
            const Edge &tar = e[q[i].p];
            gph[tar.x].push_back(tar.y);
            if(dist[tar.y] > dist[tar.x] + 1){
                dist[tar.y] = dist[tar.x] + 1;
                update(tar.y);
            }
        }
        else q[i].res = dist[q[i].p] == 1e9? -1 : dist[q[i].p];
    }
    
    for(int i = 1; i <= Q; i++){
        if(q[i].t == 'U') continue;
        cout << q[i].res << '\n';
    }
    
    return 0;
}