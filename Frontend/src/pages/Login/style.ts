import styled, { css } from 'styled-components';

export const Title = styled.h1`
  font-size: 30px;
`;

export const OauthButton = styled.button``;

export const Content = styled.h3`
  font-size: 20px;
`;

export const flexColumn = css`
  display: flex;
  flex-direction: column;
`;

export const LoginContainer = styled.div`
  ${flexColumn}
  width: 200px;
  height: 36px;
  margin: 0 auto;
`;

export const LoginInput = styled.input``;

export const LoginButton = styled.button``;

export const SignUpButton = styled.button``;
