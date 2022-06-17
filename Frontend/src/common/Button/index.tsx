import * as S from './style';

type ButtonProps = {
  type: 'button' | 'submit' | 'reset' | undefined;
  content: string;
  disabled?: boolean;
  className?: string;
  handleClick?: () => void;
};

function Button({
  type,
  className,
  content,
  disabled = false,
  handleClick,
}: ButtonProps) {
  return (
    <S.Button
      className={className}
      type={type}
      disabled={disabled}
      onClick={handleClick}
    >
      {content}
    </S.Button>
  );
}

export default Button;
