- server beanstalk github action deploy
    - https://jojoldu.tistory.com/549
- environment Development & Production
    - client
        // 상태에 따라 api base url 변경
        - .env.development
        - .env.production
    - server
        - application.properties
        - spring.profiles.active = develop / product으로 구분
            - 로컬에서 개발할 경우 product로 변경

            // 상태에 따라 port 번호 변경(추후 db 정보도 추가할 예정)
            - application-development.properties
            - application-production.properties
    
    - 그외
        - client는 https, server는 http인 상태라서 `안전하지 않은 콘텐츠`를 `허용`하지 않으면 연결되지 않는 상태..
            - 추후 server에 https 붙여야함