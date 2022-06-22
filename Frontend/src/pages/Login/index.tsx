import React, { useCallback, useState } from 'react';
import { Link } from 'react-router-dom';

import * as S from './style';

const LOGIN_ID = 'loginId';
const LOGIN_PASSWORD = 'loginPassword';

export default function Login() {
  const issueNumber = 1;
  const [loginInputValue, setLoginInputValue] = useState({
    id: '',
    password: '',
  });

  const isLoginButtonActive =
    loginInputValue.id !== '' && loginInputValue.password !== '';

  const handleChange = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      if (e.currentTarget.classList.contains(LOGIN_ID)) {
        setLoginInputValue({ ...loginInputValue, id: e.currentTarget.value });
      } else if (e.currentTarget.classList.contains(LOGIN_PASSWORD)) {
        setLoginInputValue({
          ...loginInputValue,
          password: e.currentTarget.value,
        });
      }
    },
    [loginInputValue]
  );

  return (
    <S.LoginContainer>
      <S.Title>Issue Tracker</S.Title>
      <Link to="/main">
        <S.OauthButton type="button" content="GitHub 계정으로 로그인" />
      </Link>
      <S.Content>or</S.Content>
      <S.LoginInput
        type="text"
        className={LOGIN_ID}
        placeholder="아이디"
        onChange={handleChange}
      />
      <S.LoginInput
        type="text"
        className={LOGIN_PASSWORD}
        placeholder="비밀번호"
        onChange={handleChange}
      />
      {/* TODO : issue 목록중 하나 선택 예시, 추후 이슈 목록 완성되면 그곳에 Link */}
      <S.LoginLink to={`/issue/${issueNumber}`}>
        <S.LoginButton
          type="button"
          content="아이디로 로그인"
          disabled={!isLoginButtonActive}
        />
      </S.LoginLink>
      <S.SignUpButton type="button" content="회원가입" />
    </S.LoginContainer>
  );
}
