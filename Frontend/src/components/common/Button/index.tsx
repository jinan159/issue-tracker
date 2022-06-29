import * as S from './style';

type ButtonProps = {
  type: 'button' | 'submit' | 'reset' | undefined;
  content: string;
  disabled?: boolean;
  className?: string;
  handleClick?: () => void;
  children?: JSX.Element | JSX.Element[];
};

function Button({
  type,
  className,
  content,
  disabled = false,
  handleClick,
  children,
}: ButtonProps) {
  return (
    <S.Button
      className={className}
      type={type}
      disabled={disabled}
      onClick={handleClick}
    >
      {content}
      {children}
    </S.Button>
  );
}

export default Button;
