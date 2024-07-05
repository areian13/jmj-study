## 민주의 알고리즘 스터디
민주를 위한 알고리즘 스터디 레포지토리입니다.

### 스터디의 목적
1. 백준 기준 기초난이도가 골드 이하인 그래프 알고리즘들을 습득한다.  
2. 자신의 코딩 스타일을 정형화하고, 클린 코드를 작성한다.  
3. 깃허브의 기본적인 사용법을 익힌다.

### 커리큘럼
    1주차: 기초수학(유클리드 호제법, 진법변환, 소수 판정)  
    2주차: 자료구조(스택, 큐, 우선순위 큐, 맵, 셋)  
    3주차: 분할정복, 백트레킹  
    4주차: 벨만포드, 플로이드 워셜  
    5주차: DFS, BFS, 다익스트라  
    6주차: MST  
    7주차: 위상정렬  
    8주차: 최소공통조상  
    9주차: 세그먼트 트리  

### 수업 준비
    제가 특별히 해와라 하는 것이 없다면, 수업 시간 전 해당 레포지토리의 터미널에  
    git fetch  
    git pull  
    git checkout main  
    해주시면 제가 올린 수업 자료가 있을 것입니다.  

### 수업 시간 중
1. 지난주 과제 리뷰  
2. 진도 나가기
3. 대표 문제 풀이

### 과제
1. 문제 해결

    과제는 n주차/과제 디렉토리에 "n주차 과제.md"파일에 있습니다.  
    단순히 문제만 있을수도, 상세한 조건이 있을수도 있습니다. 조건에 맞게 자신의 언어로 해결하시면 됩니다.
    
    [ 필과 ]는 필수과제란 의미로 해당 문제는 반드시 풀이를 "시도"하여야합니다. 반드시 맞을 필욘 없고, 백준에 제출해보지 않아도 되지만 풀었던 흔적이 남은 코드를 제출하셔야합니다. 따라서 필과의 경우엔 무슨 일이 있어도 코드를 제출하셔야합니다.  
    
    [ 선과 k ]는 선택과제 중 적어도 k개는 풀라는 것입니다. 0개라면 안풀어도 되지만 1개라면 여러 선택 과제중 한 개 이상 아무거나 골라서 풀어오시면 됩니다.  
    
    웬만하면 쉬운 기본 문제가 필과, 좀 생각을 해야하는 어려운 문제는 선과로 분류됩니다.  
    
2. 솔루션코드 파일 경로

    "n주차/과제" 폴더 밑에, 즉, "n주차 과제.md" 파일과 동일한 경로에 자신의 백준 아이디로 폴더를 만드신 후, 해당 경로에 솔루션 코드를 넣으시면 됩니다.  
      
    본인이 문제를 해결하고 실행시키는 환경과, 해당 스터디를 위해 파일을 제출하는 레포지토리는 분리하는 것이 편할 듯 합니다.  


3. 솔루션코드 파일명 포맷
    "숙제번호. 문제명 (해결여부).확장자"  
    ex) 1. 소수 (시간초과).cpp, 2. 에라토스테네스의 체 (틀렸습니다).java  
  
    맞았을 경우엔 "맞았습니다" 대신 (메모리KB, 시간ms)로 작성해주세요.  
    ex) 1. 소수 (2072KB, 0ms).cpp  

    점수가 있는 문제에서 만점을 받지 못한 경우 제출 코드를 보시면 만점을 받지 못한 사유가 써있으니 해당 사유를 작성해주시면 됩니다.  

    시도를 하였으나, 너무 어려워 접근조차 어려울 경우 (시도)라고 표시하시면 됩니다.  
    자신이 어디까지 시도했고, 무슨 사고를 거쳤는지 코드로 남기든 주석을 남기든 하시면 됩니다.  

    자바와 같이 파일명이 클래스명과 같아야하는 언어에선 클래스명은 Main으로 하고 파일탐색기에서 파일명을 강제로 바꿔주세요. 또한 만약 어떤 폴더에 속해 pakage가 돼있으면 해당 부분도 지워주세요. 즉, 제가 코드를 그대로 복붙하여 백준에 제출해볼 수 있는 형태로 바꿔주세요.  


4. 깃허브 제출

    1. 깃허브의 week{n} 브런치에서 week{n}-백준아이디 브랜치를 새로 파줍니다.  
    ~~혹여나 week{n} 브랜치가 없다면 제가 까먹은거니 편하게 연락주세요.~~  
    ex) week1-areian13  

    2. 자신의 레포지토리 터미널에서 
    git checkout week{n}-백준아이디 (week1-areian13)  
    git status -> **위 브랜치로 이동되었는지 반드시 확인**  
    git add .  
    git commit -m "아이디 n주차 과제 제출" (areian13 1주차 과제 제출)  
    git push  
    해주시면 됩니다.

    3. 깃허브로 돌아와 Pull requests를 누릅니다.  
    집중합시다 pr은 자신이 작업한 내용을 프로젝트 관리자에게 다른 코드들과 합쳐달라고 요청하는 과정입니다.  
    base가 기존의 코드, compare가 자신이 새롭게 작업한 브랜치입니다.  
    
    base: week{n} 브랜치 선택  
    compare: 직접 생성한 week{n}-백준아이디 브랜치 선택  
    
    **브랜치 제대로 선택했는지 반드시 확인해주세요**  

    Create pull request 클릭  
    pr명은 commit 메세지와 동일하게 "아이디 n주차 과제 제출"  
    우측에 Reviewers는 저(areian13), Assignees는 본인 선택  
    pr 제출  

    **절대로 무슨 일이 있어도 본인이 올린 pr을 본인이 직접 merge해서는 안됩니다**


5. pr 후, 피드백  

    피드백 이후엔 제가 어느정도 만족할 때까지 수정을 요구할 수도 있고, 이 정도면 됐다 싶으면 pr을 수락하여 week1 브랜치로 merge할 것입니다.  

    피드백 이후엔 다시 코드 수정 후,  
    본인의 브랜치에서  
    git add .  
    git commit -m "아이디 n주차 과제 제출 k" (areian13 1주차 과제 제출 2,3,...)  
    git push  
    하시면 전에 pr했던 곳에 자동으로 추가됩니다.