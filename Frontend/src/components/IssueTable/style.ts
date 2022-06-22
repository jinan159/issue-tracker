import styled from 'styled-components';

const Container = styled.div`
  width: 1280px;
  border: 1px solid ${({ theme }) => theme.colors.greyScale.line};
  border-radius: 16px;
  overflow: hidden;
`;

export { Container };
