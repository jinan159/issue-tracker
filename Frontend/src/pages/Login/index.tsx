import axios, { AxiosResponse } from 'axios';
import React, { useCallback, useState } from 'react';

import * as S from './style';

const LOGIN_REQUEST_URL = '/login';

export default function Login() {
  const issueNumber = 1;
  const [loginInputValue, setLoginInputValue] = useState({
    id: '',
    password: '',
  });

  const isLoginButtonActive =
    loginInputValue.id !== '' && loginInputValue.password !== '';

  const handleChange = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>, type: 'id' | 'password') => {
      switch (type) {
        case 'id':
          setLoginInputValue({ ...loginInputValue, id: e.currentTarget.value });
          break;
        case 'password':
          setLoginInputValue({
            ...loginInputValue,
            password: e.currentTarget.value,
          });
          break;
        default:
          break;
      }
    },
    [loginInputValue]
  );

  const handleClickLogin = async () => {
    const url: AxiosResponse = await axios.get(LOGIN_REQUEST_URL);
    console.log(url.data);
    window.location.href = url.data;
  };

  return (
    <S.LoginContainer>
      <S.Title>Issue Tracker</S.Title>
      <S.OauthButton
        type="button"
        content="GitHub 계정으로 로그인"
        handleClick={handleClickLogin}
      />
      <S.Content>or</S.Content>
      <S.LoginInput
        type="text"
        placeholder="아이디"
        onChange={(e) => handleChange(e, 'id')}
      />
      <S.LoginInput
        type="text"
        placeholder="비밀번호"
        onChange={(e) => handleChange(e, 'password')}
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
