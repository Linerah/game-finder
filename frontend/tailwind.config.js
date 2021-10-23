module.exports = {
  prefix: '',
  mode: 'jit',
  purge: {
    content: [
      './src/**/*.{html,ts}',
    ]
  },
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      colors: {
        'background-purple':'#242038',
        'about-grey': '#393939',
        'about-blue': '#B8EBFA',

      },
      borderRadius: {
        'about-border': '50px',
      }
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
