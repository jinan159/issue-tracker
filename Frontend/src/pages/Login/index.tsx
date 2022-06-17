import { Link } from 'react-router-dom';

import * as S from './style';

export default function Login() {
  const issueNumber = 1;

  return (
    <S.LoginContainer>
      <S.Title>Issue Tracker</S.Title>
      <Link to="/main">
        <S.OauthButton type="button">GitHub 계정으로 로그인</S.OauthButton>
      </Link>
      <S.Content>or</S.Content>
      <S.LoginInput type="text" placeholder="아이디" />
      <S.LoginInput type="text" placeholder="비밀번호" />
      {/* TODO : issue 목록중 하나 선택 예시, 추후 이슈 목록 완성되면 그곳에 Link */}
      <Link to={`/issue/${issueNumber}`}>
        <S.LoginButton type="button">아이디로 로그인</S.LoginButton>
      </Link>
      <S.SignUpButton type="button">회원가입</S.SignUpButton>
    </S.LoginContainer>
  );
}
