import { Link } from 'react-router-dom';
import styled from 'styled-components';

import Button from '../../components/common/Button';

export const Title = styled.h1`
  font-style: italic;
  font-weight: 400;
  font-size: 56px;
  line-height: 72px;
  color: ${({ theme }) => theme.color.black};
  margin-bottom: 61px;
`;

const ButtonSize = `
  width: 340px;
  height: 64px;
`;

export const OauthButton = styled(Button)`
  ${ButtonSize};
  background: ${({ theme }) => theme.color.black};
  border-radius: 20px;
  font-weight: 700;
  font-size: 18px;
  line-height: 32px;
  color: ${({ theme }) => theme.color.white};
`;

export const Content = styled.p`
  font-weight: 700;
  font-size: 16px;
  color: ${({ theme }) => theme.color.greyPlaceholder};
  margin: 24px 0;
`;

export const LoginContainer = styled.div`
  ${({ theme: { mixins } }) => `
		${mixins.flexBox('column', 'center', 'center')};
		width: 100%;
		height: 100%;
	`}
`;

export const LoginInput = styled.input`
  ${ButtonSize};
  padding: 0 24px;
  background: ${({ theme }) => theme.color.grey3};
  border-radius: 16px;
  &:not(:last-child) {
    margin-bottom: 16px;
  }
  font-weight: 400;
  font-size: 16px;
  line-height: 28px;
  color: ${({ theme }) => theme.color.greyPlaceholder};
`;

export const LoginButton = styled(Button)`
  ${ButtonSize};
  padding: 0 24px;
  background: ${({ theme }) => theme.color.blue1};
  border-radius: 20px;
  font-weight: 700;
  font-size: 18px;
  line-height: 32px;
  color: ${({ theme }) => theme.color.white};
  :disabled {
    color: ${({ theme }) => theme.color.white};
    background: ${({ theme }) => theme.color.blue2};
    :hover {
      color: ${({ theme }) => theme.color.white};
    }
  }
`;

export const LoginLink = styled(Link)`
  ${ButtonSize};
  border-radius: 20px;
  margin: 24px 0 30px 0;
`;

export const SignUpButton = styled(Button)`
  font-weight: 700;
  font-size: 12px;
  line-height: 20px;
  color: ${({ theme }) => theme.color.greyBody};
`;
