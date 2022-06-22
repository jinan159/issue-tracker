import styled from 'styled-components';

import Button from '../../common/Button';

const Container = styled.div`
  width: 1280px;
  height: 64px;
  background: ${({ theme }) => theme.colors.greyScale.background};
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'space-between')};
  padding: 0 32px 0 32px;
  box-sizing: border-box;
`;

const IssueButton = styled(Button)`
  font-weight: 700;
  font-size: 16px;
  line-height: 28px;
  color: ${({ theme }) => theme.colors.greyScale.titleActive};
`;

const SortButton = styled(Button)`
  font-weight: 700;
  font-size: 16px;
  line-height: 28px;
  color: ${({ theme }) => theme.colors.greyScale.label};
  background: none;
  &:hover {
    color: ${({ theme }) => theme.colors.blueScale.lightBlue};
  }
`;

const Wrapper1 = styled.div`
  *:not(:last-child) {
    margin-right: 32px;
  }
`;

const Wrapper2 = styled.div`
  *:not(:last-child) {
    margin-right: 22px;
  }
`;

export { Container, IssueButton, SortButton, Wrapper1, Wrapper2 };
